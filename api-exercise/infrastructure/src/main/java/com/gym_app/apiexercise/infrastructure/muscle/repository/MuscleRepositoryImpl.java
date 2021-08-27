package com.gym_app.apiexercise.infrastructure.muscle.repository;

import com.gym_app.apiexercise.domain.muscle.Muscle;
import com.gym_app.apiexercise.domain.muscle.repository.MuscleRepository;
import com.gym_app.apiexercise.domain.shared.SharedPage;
import com.gym_app.apiexercise.domain.shared.SharedPageRequest;
import com.gym_app.apiexercise.infrastructure.muscle.dao.MuscleDAO;
import com.gym_app.apiexercise.infrastructure.muscle.entity.MuscleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

import static org.apache.logging.log4j.util.Strings.isEmpty;

@Repository
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class MuscleRepositoryImpl implements MuscleRepository {

    private final MuscleDAO muscleDAO;
    private final MongoTemplate mongoTemplate;

    @Override
    public SharedPage<Muscle> findPagedByFilter(Muscle muscle, SharedPageRequest pageRequest) {
        int pageNumber = pageRequest.getPageNumber() > 0 ? pageRequest.getPageNumber()-1 : 0;
        Pageable pageable = PageRequest.of(pageNumber, pageRequest.getPageSize());

        Query queryCount = new Query();
        if (!isEmpty(muscle.getName())) {
            String regex = ".*" + muscle.getName() + ".*";
            queryCount.addCriteria(Criteria.where("name").regex(regex, "i"));
        }
        Query queryPageable = Query.of(queryCount).with(pageable);

        List<MuscleEntity> muscles = mongoTemplate.find(queryPageable, MuscleEntity.class);

        Page<Muscle> page = PageableExecutionUtils
                .getPage(muscles, pageable, () -> mongoTemplate.count(queryCount, MuscleEntity.class))
                .map(MuscleEntity::toDomain);
        return SharedPage
                .<Muscle>builder()
                .content(page.getContent())
                .pageNumber(page.getNumber()+1)
                .pageSize(page.getSize())
                .totalElements(page.getTotalElements())
                .build();
    }

    @Override
    public Optional<Muscle> findById(String id) {
        return muscleDAO
                .findById(id)
                .map(MuscleEntity::toDomain);
    }

    @Override
    public Muscle create(Muscle muscle) {
        return muscleDAO.save(MuscleEntity.from(muscle)).toDomain();
    }

    @Override
    public Muscle update(Muscle muscle) {
        return muscleDAO.save(MuscleEntity.from(muscle)).toDomain();
    }

    @Override
    public Optional<Muscle> findByName(String name) {
        return muscleDAO
                .findByName(name)
                .map(MuscleEntity::toDomain);
    }
}

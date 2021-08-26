package com.gym_app.apiexercise.infrastructure.muscle.repository;

import com.gym_app.apiexercise.domain.muscle.Muscle;
import com.gym_app.apiexercise.domain.muscle.repository.MuscleRepository;
import com.gym_app.apiexercise.infrastructure.muscle.dao.MuscleDAO;
import com.gym_app.apiexercise.infrastructure.muscle.entity.MuscleEntity;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

@Named
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class MuscleRepositoryImpl implements MuscleRepository {

    private final MuscleDAO muscleDAO;

    @Override
    public Muscle create(Muscle muscle) {
        return muscleDAO.save(MuscleEntity.from(muscle)).toDomain();
    }

    @Override
    public Optional<Muscle> findByName(String name) {
        return muscleDAO.findByName(name);
    }
}

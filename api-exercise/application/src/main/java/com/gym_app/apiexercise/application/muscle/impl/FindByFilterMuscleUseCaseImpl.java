package com.gym_app.apiexercise.application.muscle.impl;

import com.gym_app.apiexercise.application.muscle.FindByFilterMuscleUseCase;
import com.gym_app.apiexercise.application.muscle.request.FindByFilterMuscleRequest;
import com.gym_app.apiexercise.application.muscle.response.MuscleResponse;
import com.gym_app.apiexercise.domain.muscle.Muscle;
import com.gym_app.apiexercise.domain.muscle.repository.MuscleRepository;
import com.gym_app.apiexercise.domain.shared.SharedPage;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.stream.Collectors;

@Named
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class FindByFilterMuscleUseCaseImpl implements FindByFilterMuscleUseCase {

    private final MuscleRepository muscleRepository;

    @Override
    public SharedPage<MuscleResponse> execute(FindByFilterMuscleRequest request) {
        request.validateSelf();
        SharedPage<Muscle> pagedByFilter = muscleRepository
                .findPagedByFilter(request.toDomain(), request.getPageRequest());
        return SharedPage
                .<MuscleResponse>builder()
                .content(pagedByFilter.getContent().stream().map(MuscleResponse::from).collect(Collectors.toList()))
                .pageNumber(pagedByFilter.getPageNumber())
                .pageSize(pagedByFilter.getPageSize())
                .totalElements(pagedByFilter.getTotalElements())
                .build();
    }
}

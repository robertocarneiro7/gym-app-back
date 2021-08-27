package com.gym_app.apiexercise.application.muscle.impl;

import com.gym_app.apiexercise.application.muscle.FindByIdMuscleUseCase;
import com.gym_app.apiexercise.application.muscle.response.MuscleResponse;
import com.gym_app.apiexercise.domain.muscle.repository.MuscleRepository;
import com.gym_app.apiexercise.domain.shared.exception.BusinessException;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class FindByIdMuscleUseCaseImpl implements FindByIdMuscleUseCase {

    private final MuscleRepository muscleRepository;

    @Override
    public MuscleResponse execute(String id) {
        return muscleRepository
                .findById(id)
                .map(MuscleResponse::from)
                .orElseThrow(() -> new BusinessException("Músculo não encontrado"));
    }
}

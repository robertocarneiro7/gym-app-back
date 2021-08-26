package com.gym_app.apiexercise.application.muscle.impl;

import com.gym_app.apiexercise.application.muscle.CreateMuscleUseCase;
import com.gym_app.apiexercise.application.muscle.request.CreateMuscleRequest;
import com.gym_app.apiexercise.application.muscle.response.MuscleResponse;
import com.gym_app.apiexercise.domain.muscle.Muscle;
import com.gym_app.apiexercise.domain.muscle.repository.MuscleRepository;
import com.gym_app.apiexercise.domain.shared.exception.BusinessException;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class CreateMuscleUseCaseImpl implements CreateMuscleUseCase {

    private final MuscleRepository muscleRepository;

    @Override
    public MuscleResponse execute(CreateMuscleRequest request) {
        Muscle muscle = request.toDomain();
        muscle.validateSelf();
        if (muscleRepository.findByName(muscle.getName()).isPresent()) {
            throw new BusinessException("Nome deve ser único");
        }
        return MuscleResponse.from(muscleRepository.create(muscle));
    }
}

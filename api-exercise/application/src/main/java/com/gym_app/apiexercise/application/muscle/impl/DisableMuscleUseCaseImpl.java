package com.gym_app.apiexercise.application.muscle.impl;

import com.gym_app.apiexercise.application.muscle.DisableMuscleUseCase;
import com.gym_app.apiexercise.application.muscle.response.MuscleResponse;
import com.gym_app.apiexercise.domain.muscle.Muscle;
import com.gym_app.apiexercise.domain.muscle.repository.MuscleRepository;
import com.gym_app.apiexercise.domain.shared.exception.BusinessException;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.inject.Named;

import static java.util.Objects.nonNull;

@Named
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class DisableMuscleUseCaseImpl implements DisableMuscleUseCase {

    private final MuscleRepository muscleRepository;

    @Override
    public MuscleResponse execute(String id) {
        Muscle muscleOnDB = muscleRepository
                .findById(id)
                .orElseThrow(() -> new BusinessException("Músculo não encontrado"));

        if (nonNull(muscleOnDB.getDisabledDate())) {
            throw new BusinessException("Músculo já desabilitado");
        }

        return muscleRepository
                .disable(id)
                .map(MuscleResponse::from)
                .orElse(null);
    }
}

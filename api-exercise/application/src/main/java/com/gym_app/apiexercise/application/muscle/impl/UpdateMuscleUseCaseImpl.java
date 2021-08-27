package com.gym_app.apiexercise.application.muscle.impl;

import com.gym_app.apiexercise.application.muscle.UpdateMuscleUseCase;
import com.gym_app.apiexercise.application.muscle.request.UpdateMuscleRequest;
import com.gym_app.apiexercise.application.muscle.response.MuscleResponse;
import com.gym_app.apiexercise.domain.muscle.Muscle;
import com.gym_app.apiexercise.domain.muscle.repository.MuscleRepository;
import com.gym_app.apiexercise.domain.shared.exception.BusinessException;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Objects;

import static java.util.Objects.nonNull;

@Named
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class UpdateMuscleUseCaseImpl implements UpdateMuscleUseCase {

    private final MuscleRepository muscleRepository;

    @Override
    public MuscleResponse execute(String id, UpdateMuscleRequest request) {
        Muscle muscleRequest = request.toDomain();
        muscleRequest.validateSelf();
        Muscle muscleOnDB = muscleRepository
                .findById(id)
                .orElseThrow(() -> new BusinessException("Músculo não encontrado"));
        if (!Objects.equals(muscleOnDB.getName(), muscleRequest.getName())
                && muscleRepository.findByName(muscleRequest.getName()).isPresent()) {
            throw new BusinessException("Nome deve ser único");
        }
        if (nonNull(muscleOnDB.getDisabledDate())) {
            throw new BusinessException("Músculo não pode ser editado, pois está desabilitado");
        }
        Muscle muscleToSave = muscleOnDB.toBuilder().name(request.getName()).build();
        return MuscleResponse.from(muscleRepository.update(muscleToSave));
    }
}

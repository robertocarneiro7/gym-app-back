package com.gym_app.apiexercise.domain.muscle.repository;

import com.gym_app.apiexercise.domain.muscle.Muscle;
import com.gym_app.apiexercise.domain.shared.SharedPage;
import com.gym_app.apiexercise.domain.shared.SharedPageRequest;

import java.util.Optional;

public interface MuscleRepository {

    SharedPage<Muscle> findPagedByFilter(Muscle muscle, SharedPageRequest pageRequest);

    Optional<Muscle> findById(String id);

    Muscle create(Muscle muscle);

    Muscle update(Muscle muscle);

    Optional<Muscle> findByName(String name);
}

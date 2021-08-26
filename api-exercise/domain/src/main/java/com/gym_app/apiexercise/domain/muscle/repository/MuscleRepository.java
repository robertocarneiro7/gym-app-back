package com.gym_app.apiexercise.domain.muscle.repository;

import com.gym_app.apiexercise.domain.muscle.Muscle;

import java.util.Optional;

public interface MuscleRepository {

    Muscle create(Muscle muscle);

    Optional<Muscle> findByName(String name);
}

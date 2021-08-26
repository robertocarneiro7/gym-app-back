package com.gym_app.apiexercise.infrastructure.muscle.dao;

import com.gym_app.apiexercise.domain.muscle.Muscle;
import com.gym_app.apiexercise.infrastructure.muscle.entity.MuscleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MuscleDAO extends MongoRepository<MuscleEntity, String> {

    Optional<Muscle> findByName(String name);
}

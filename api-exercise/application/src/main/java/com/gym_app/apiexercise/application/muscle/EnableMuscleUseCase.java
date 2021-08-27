package com.gym_app.apiexercise.application.muscle;

import com.gym_app.apiexercise.application.muscle.response.MuscleResponse;

public interface EnableMuscleUseCase {

    MuscleResponse execute(String id);
}

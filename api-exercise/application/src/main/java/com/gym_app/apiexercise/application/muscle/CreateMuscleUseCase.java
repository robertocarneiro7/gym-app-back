package com.gym_app.apiexercise.application.muscle;

import com.gym_app.apiexercise.application.muscle.response.MuscleResponse;
import com.gym_app.apiexercise.application.muscle.request.CreateMuscleRequest;

public interface CreateMuscleUseCase {

    MuscleResponse execute(CreateMuscleRequest request);
}

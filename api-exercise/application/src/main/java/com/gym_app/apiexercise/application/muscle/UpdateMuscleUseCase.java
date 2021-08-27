package com.gym_app.apiexercise.application.muscle;

import com.gym_app.apiexercise.application.muscle.request.UpdateMuscleRequest;
import com.gym_app.apiexercise.application.muscle.response.MuscleResponse;

public interface UpdateMuscleUseCase {

    MuscleResponse execute(String id, UpdateMuscleRequest request);
}

package com.gym_app.apiexercise.application.muscle;

import com.gym_app.apiexercise.application.muscle.request.FindByFilterMuscleRequest;
import com.gym_app.apiexercise.application.muscle.response.MuscleResponse;
import com.gym_app.apiexercise.domain.shared.SharedPage;

public interface FindByFilterMuscleUseCase {

    SharedPage<MuscleResponse> execute(FindByFilterMuscleRequest request);
}

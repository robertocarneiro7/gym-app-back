package com.gym_app.apiexercise.api.controller;

import com.gym_app.apiexercise.application.muscle.CreateMuscleUseCase;
import com.gym_app.apiexercise.application.muscle.request.CreateMuscleRequest;
import com.gym_app.apiexercise.application.muscle.response.MuscleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/muscles")
@RequiredArgsConstructor
public class MuscleController {

    private final CreateMuscleUseCase createMuscleUseCase;

    @PostMapping
    public MuscleResponse create(@RequestBody CreateMuscleRequest request) {
        return createMuscleUseCase.execute(request);
    }
}

package com.gym_app.apiexercise.api.controller;

import com.gym_app.apiexercise.application.muscle.*;
import com.gym_app.apiexercise.application.muscle.request.CreateMuscleRequest;
import com.gym_app.apiexercise.application.muscle.request.FindByFilterMuscleRequest;
import com.gym_app.apiexercise.application.muscle.request.UpdateMuscleRequest;
import com.gym_app.apiexercise.application.muscle.response.MuscleResponse;
import com.gym_app.apiexercise.domain.shared.SharedPage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/muscles")
@RequiredArgsConstructor
public class MuscleController {

    private final FindByFilterMuscleUseCase findByFilterMuscleUseCase;
    private final FindByIdMuscleUseCase findByIdMuscleUseCase;
    private final CreateMuscleUseCase createMuscleUseCase;
    private final UpdateMuscleUseCase updateMuscleUseCase;
    private final EnableMuscleUseCase enableMuscleUseCase;
    private final DisableMuscleUseCase disableMuscleUseCase;

    @PostMapping("/find")
    public SharedPage<MuscleResponse> findByFilter(@RequestBody FindByFilterMuscleRequest request) {
        return findByFilterMuscleUseCase.execute(request);
    }

    @GetMapping("/{id}")
    public MuscleResponse findById(@PathVariable String id) {
        return findByIdMuscleUseCase.execute(id);
    }

    @PostMapping
    public MuscleResponse create(@RequestBody CreateMuscleRequest request) {
        return createMuscleUseCase.execute(request);
    }

    @PutMapping("/{id}")
    public MuscleResponse update(@PathVariable String id, @RequestBody UpdateMuscleRequest request) {
        return updateMuscleUseCase.execute(id, request);
    }

    @PutMapping("/{id}/enable")
    public MuscleResponse enable(@PathVariable String id) {
        return enableMuscleUseCase.execute(id);
    }

    @PutMapping("/{id}/disable")
    public MuscleResponse disable(@PathVariable String id) {
        return disableMuscleUseCase.execute(id);
    }
}

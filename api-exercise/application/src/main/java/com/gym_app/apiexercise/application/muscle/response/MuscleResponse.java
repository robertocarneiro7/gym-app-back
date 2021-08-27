package com.gym_app.apiexercise.application.muscle.response;

import com.gym_app.apiexercise.domain.muscle.Muscle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Getter
public class MuscleResponse {

    private String id;
    private String name;
    private LocalDateTime disabledDate;

    public static MuscleResponse from(Muscle muscle) {
        return MuscleResponse
                .builder()
                .id(muscle.getId())
                .name(muscle.getName())
                .disabledDate(muscle.getDisabledDate())
                .build();
    }
}

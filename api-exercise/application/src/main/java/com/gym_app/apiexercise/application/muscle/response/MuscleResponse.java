package com.gym_app.apiexercise.application.muscle.response;

import com.gym_app.apiexercise.domain.muscle.Muscle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import static java.util.Objects.isNull;

@AllArgsConstructor
@Builder
@Getter
public class MuscleResponse {

    private String id;
    private String name;
    private boolean enabled;

    public static MuscleResponse from(Muscle muscle) {
        return MuscleResponse
                .builder()
                .id(muscle.getId())
                .name(muscle.getName())
                .enabled(isNull(muscle.getDisabledDate()))
                .build();
    }
}

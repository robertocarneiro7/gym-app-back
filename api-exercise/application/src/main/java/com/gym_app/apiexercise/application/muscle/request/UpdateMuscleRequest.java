package com.gym_app.apiexercise.application.muscle.request;

import com.gym_app.apiexercise.domain.muscle.Muscle;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UpdateMuscleRequest {

    private String name;

    public Muscle toDomain() {
        return Muscle
                .builder()
                .name(this.name)
                .build();
    }
}

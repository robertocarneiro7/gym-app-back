package com.gym_app.apiexercise.application.muscle.request;

import com.gym_app.apiexercise.domain.muscle.Muscle;
import com.gym_app.apiexercise.domain.shared.SelfValidating;
import com.gym_app.apiexercise.domain.shared.SharedPageRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class FindByFilterMuscleRequest extends SelfValidating<FindByFilterMuscleRequest> {

    private String name;
    @NotNull
    @Valid
    private SharedPageRequest pageRequest;

    public Muscle toDomain() {
        return Muscle
                .builder()
                .name(this.name)
                .build();
    }
}

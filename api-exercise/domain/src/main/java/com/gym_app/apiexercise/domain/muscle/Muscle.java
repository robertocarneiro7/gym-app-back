package com.gym_app.apiexercise.domain.muscle;

import com.gym_app.apiexercise.domain.shared.SelfValidating;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class Muscle extends SelfValidating<Muscle> {

    private String id;

    @Size(min = 3, max = 30)
    private String name;
}

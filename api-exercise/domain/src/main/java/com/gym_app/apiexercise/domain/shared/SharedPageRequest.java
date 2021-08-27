package com.gym_app.apiexercise.domain.shared;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class SharedPageRequest {

    @NotNull
    private Integer pageNumber;
    @NotNull
    private Integer pageSize;
}

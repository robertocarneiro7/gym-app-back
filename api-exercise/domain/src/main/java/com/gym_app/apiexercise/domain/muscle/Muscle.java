package com.gym_app.apiexercise.domain.muscle;

import com.gym_app.apiexercise.domain.shared.SelfValidating;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder(toBuilder = true)
@Getter
public class Muscle extends SelfValidating<Muscle> {

    private String id;
    @NotNull
    @Size(min = 3, max = 30)
    private String name;
    private LocalDateTime createdDate;
    private String createdBy;
    private LocalDateTime lastModifiedDate;
    private String lastModifiedBy;
    private LocalDateTime disabledDate;
    private String disabledBy;
}

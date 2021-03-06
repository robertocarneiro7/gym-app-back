package com.gym_app.apiexercise.infrastructure.muscle.entity;

import com.gym_app.apiexercise.domain.muscle.Muscle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("muscles")
@AllArgsConstructor
@Builder
@Getter
public class MuscleEntity {

    @Id
    private String id;
    private String name;
    @CreatedDate
    private LocalDateTime createdDate;
    @CreatedBy
    private String createdBy;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
    @LastModifiedBy
    private String lastModifiedBy;
    private LocalDateTime disabledDate;
    private String disabledBy;

    public static MuscleEntity from(Muscle muscle) {
        return MuscleEntity
                .builder()
                .id(muscle.getId())
                .name(muscle.getName())
                .createdDate(muscle.getCreatedDate())
                .createdBy(muscle.getCreatedBy())
                .lastModifiedDate(muscle.getLastModifiedDate())
                .lastModifiedBy(muscle.getLastModifiedBy())
                .disabledDate(muscle.getDisabledDate())
                .disabledBy(muscle.getDisabledBy())
                .build();
    }

    public Muscle toDomain() {
        return Muscle
                .builder()
                .id(this.id)
                .name(this.name)
                .createdDate(this.createdDate)
                .createdBy(this.createdBy)
                .lastModifiedDate(this.lastModifiedDate)
                .lastModifiedBy(this.lastModifiedBy)
                .disabledDate(this.disabledDate)
                .disabledBy(this.disabledBy)
                .build();
    }
}

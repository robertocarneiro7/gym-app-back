package com.gym_app.apiexercise.infrastructure.muscle.entity;

import com.gym_app.apiexercise.domain.muscle.Muscle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
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
    private String createdBy;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
    private String lastModifiedBy;
    private LocalDateTime disabledDate;
    private String disabledBy;

    public static MuscleEntity from(Muscle muscle) {
        return MuscleEntity
                .builder()
                .id(muscle.getId())
                .name(muscle.getName())
                .build();
    }

    public Muscle toDomain() {
        return Muscle
                .builder()
                .id(this.id)
                .name(this.name)
                .build();
    }
}

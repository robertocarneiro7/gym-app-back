package com.gym_app.apiexercise.domain.shared;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class SharedPage<T> {

    private List<T> content;
    private int pageNumber;
    private int pageSize;
    private long totalElements;

    public int getTotalPages() {
        if (this.content.isEmpty() && this.totalElements == 0) {
            return 1;
        } else {
            return BigDecimal.valueOf(this.totalElements)
                    .divide(BigDecimal.valueOf(this.pageSize), RoundingMode.CEILING)
                    .intValue();
        }
    }

    public SharedPageRequest getPrevious() {
        int pageNumberPrevious = this.pageNumber-1;
        if (pageNumberPrevious < 1) {
            return null;
        }
        return SharedPageRequest
                .builder()
                .pageNumber(pageNumberPrevious)
                .pageSize(this.pageSize)
                .build();
    }

    public SharedPageRequest getNext() {
        int pageNumberNext = this.pageNumber+1;
        if (pageNumberNext > this.getTotalPages()) {
            return null;
        }
        return SharedPageRequest
                .builder()
                .pageNumber(pageNumberNext)
                .pageSize(this.pageSize)
                .build();
    }

}

package com.devcourse.board.common;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    @Column(name = "Created_by")
    private String createdBy;
    @Column(name = "Created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;
}

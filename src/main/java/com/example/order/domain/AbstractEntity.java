package com.example.order.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.ZonedDateTime;

/* createAt, updateAt을 매번 선언하기 번거롭기 때문에 구현 */

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity {

    /*
        springframework 에서 제공하는 @CreatedDate, @LastModifiedDate 어노테이션은
        java.time.LocalDateTime만 지원하고 ZonedDateTime를 지원하지 않아서 hibernate 사용
    */
    @CreationTimestamp
    private ZonedDateTime createAt;

    @UpdateTimestamp
    private ZonedDateTime updateAt;
}

package com.example.order.domain.partner;

import com.example.order.common.util.TokenGenerator;
import com.example.order.domain.AbstractEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
@Getter
@Entity
@NoArgsConstructor
@Table(name = "partners")
public class Partner extends AbstractEntity {
    private static final String PREFIX_PARTNER = "ptn_";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String partnerToken;
    private String partnerName;
    private String businessNo;
    private String email;

    @Enumerated(EnumType.STRING) // 데이터베이스에 저장될 때 enum의 이름이 그대로 저장될 수 있도록 함
    private Status status;

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        ENABLE("활성화"), DISABLE("비활성화");
        private final String description;
    }

    @Builder // 필드의 순서에 상관없이 명시적으로 값을 설정할 수 있고, 좀 더 유연하고 불변하는 객체를 만들 수 있어서 빌더 패턴을 사용
    public Partner(String partnerName, String businessNo, String email) {
        // String 빈값을 체크하는데 매번 작성하기 번거롭기 때문에 commons-lang를 사용(null과 length가 0인지 여부 체크)
        if (StringUtils.isEmpty(partnerName)) throw new RuntimeException("empty partnerName");
        if (StringUtils.isEmpty(businessNo)) throw new RuntimeException("empty businessNo");
        if (StringUtils.isEmpty(email)) throw new RuntimeException("empty email");

        this.partnerToken = TokenGenerator.randomCharacterWithPrefix(PREFIX_PARTNER);
        this.partnerName = partnerName;
        this.businessNo = businessNo;
        this.email = email;
        this.status = Status.ENABLE;
    }

    public void enable() {
        this.status = Status.ENABLE;
    }

    public void disable() {
        this.status = Status.DISABLE;
    }
}

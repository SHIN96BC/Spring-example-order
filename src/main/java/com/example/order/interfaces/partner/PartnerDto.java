package com.example.order.interfaces.partner;

import com.example.order.domain.partner.Partner;
import com.example.order.domain.partner.PartnerCommand;
import com.example.order.domain.partner.PartnerInfo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class PartnerDto {

    // static inner class 방식 채택
    // 장점: 그룹핑이 가능하다. 만약 register request랑 reponse를 일일이 클래스로 만들면 클래스 파일이 불필요하게 많아져서 그룹핑에 용이하지 않을 수 있는데 그런점을 보완할 수 있다.
    // 단점: 타입을 선언할 때 클래스명이 길어짐(ex: PartnerDto.RegisterRequest)
    // static이라 모든 쓰레드에서 다 같이 쓴다고 오해할 수 있는데, 명시적으로 리퀘스트 마다 새로 생성되는 클래스이기 때문에 동시성 이슈X

    // 원래 Setter를 사용하는건 지양해야 하지만 DTO의 request에 한에서는 필요에 따라 예외적으로 사용해도 무관
    @Getter
    @Setter
    @ToString
    public static class RegisterRequest {

        @NotEmpty(message = "partnerName 는 필수값입니다")
        private String partnerName;

        @NotEmpty(message = "businessNo 는 필수값입니다")
        private String businessNo;

        @Email(message = "email 형식에 맞지 않습니다")
        @NotEmpty(message = "email 는 필수값입니다")
        private String email;

    }

    @Getter
    @ToString
    public static class RegisterResponse {

        private final String partnerToken;
        private final String partnerName;
        private final String businessNo;
        private final String email;
        private final Partner.Status status;

        public RegisterResponse(PartnerInfo partnerInfo) {
            this.partnerToken = partnerInfo.getPartnerToken();
            this.partnerName = partnerInfo.getPartnerName();
            this.businessNo = partnerInfo.getBusinessNo();
            this.email = partnerInfo.getEmail();
            this.status = partnerInfo.getStatus();
        }

    }

}

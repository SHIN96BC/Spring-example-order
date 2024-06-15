package com.example.order.domain.partner;

public interface PartnerService {
    // XXXCommand == 명령 성격
    // XXXCriteria == 조회 성격
    // XXXInfo == 객체에 대한 리턴

    PartnerInfo registerPartner(PartnerCommand command);
    PartnerInfo getPartnerInfo(String partnerToken);
    PartnerInfo enablePartner(String partnerToken);
    PartnerInfo disablePartner(String partnerToken);

}

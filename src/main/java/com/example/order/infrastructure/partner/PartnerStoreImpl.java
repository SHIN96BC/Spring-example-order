package com.example.order.infrastructure.partner;

import com.example.order.common.exception.InvalidParamException;
import com.example.order.domain.partner.Partner;
import com.example.order.domain.partner.PartnerStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PartnerStoreImpl implements PartnerStore {
    private final PartnerRepository partnerRepository;

    @Override
    public Partner store(Partner initPartner) {
        if (StringUtils.isEmpty(initPartner.getPartnerToken())) throw new InvalidParamException();

        return partnerRepository.save(initPartner);
    }
}

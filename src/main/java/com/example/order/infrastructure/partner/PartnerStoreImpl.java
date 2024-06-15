package com.example.order.infrastructure.partner;

import com.example.order.domain.partner.Partner;
import com.example.order.domain.partner.PartnerStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PartnerStoreImpl implements PartnerStore {
    @Override
    public Partner store(Partner initPartner) {
        return null;
    }
}

package com.example.order.interfaces.partner;

import com.example.order.domain.partner.PartnerCommand;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface PartnerDtoMapper {

    // mapstruct를 사용하여 partnerDto.RegisterRequest 객체를 PartnerCommand 객체와 매핑 시켜서 그대로 변경
    PartnerCommand of(PartnerDto.RegisterRequest request);

}

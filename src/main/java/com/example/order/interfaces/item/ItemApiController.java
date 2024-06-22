package com.example.order.interfaces.item;

import com.example.order.application.item.ItemFacade;
import com.example.order.common.response.CommonResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/items")
public class ItemApiController {

    private final ItemFacade itemFacade;
    private final ItemDtoMapper itemDtoMapper;

    @PostMapping
    public CommonResponse registerItem(@RequestBody @Valid ItemDto.RegisterItemRequest request) {
        var partnerToken = request.getPartnerToken();
        var itemCommand = itemDtoMapper.of(request);
        var itemToken = itemFacade.registerItem(itemCommand, partnerToken);
        var response = itemDtoMapper.of(itemToken);

        return CommonResponse.success(response);
    }

    @PostMapping("/change-on-sale")
    public CommonResponse changeOnSaleItem(@RequestBody @Valid ItemDto.ChangeStatusRequest request) {
        var itemToken = request.getItemToken();
        itemFacade.changeOnSaleItem(itemToken);

        return CommonResponse.success("OK");
    }

    @PostMapping("/change-end-of-sale")
    public CommonResponse changeEndOfSaleItem(@RequestBody @Valid ItemDto.ChangeStatusRequest request) {
        var itemToken = request.getItemToken();
        itemFacade.changeEndOfSaleItem(itemToken);

        return CommonResponse.success("OK");
    }

    @GetMapping("/{itemToken}")
    public CommonResponse retrieve(@PathVariable("itemToken") String itemToken) {
        var itemInfo = itemFacade.retrieveItemInfo(itemToken);
        var response = itemDtoMapper.of(itemInfo);

        return CommonResponse.success(response);
    }

}

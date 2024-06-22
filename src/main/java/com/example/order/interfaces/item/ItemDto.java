package com.example.order.interfaces.item;

import com.example.order.domain.item.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

public class ItemDto {

    @Getter
    @Setter
    @ToString
    public static class RegisterItemRequest {

        private String partnerToken;
        private String itemName;
        private Long itemPrice;
        private List<RegisterItemOptionGroupRequest> itemOptionGroupList;

    }

    @Getter
    @Setter
    @ToString
    public static class RegisterItemOptionGroupRequest {

        private Integer ordering;
        private String itemOptionGroupName;
        private List<RegisterItemOptionRequest> itemOptionList;

    }

    @Getter
    @Setter
    @ToString
    public static class RegisterItemOptionRequest {

        private Integer ordering;
        private String itemOptionName;
        private Long itemOptionPrice;

    }

    @Getter
    @Builder
    @ToString
    public static class RegisterResponse {

        private final String itemToken;

    }

    @Getter
    @Setter
    @ToString
    public static class ChangeStatusRequest {

        private String itemToken;

    }

    @Getter
    @Builder
    @ToString
    public static class Main {

        private String itemToken;
        private Long partnerId;
        private String itemName;
        private Long itemPrice;
        private Item.Status status;
        private List<ItemOptionGroupInfo> itemOptionGroupList;


    }

    @Getter
    @Builder
    @ToString
    public static class ItemOptionGroupInfo {

        private Integer ordering;
        private String itemOptionGroupName;
        private List<ItemOptionInfo> itemOptionList;

    }

    @Getter
    @Builder
    @ToString
    public static class ItemOptionInfo {

        private Integer ordering;
        private String itemOptionName;
        private Long itemOptionPrice;

    }

}

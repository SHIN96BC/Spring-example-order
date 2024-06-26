package com.example.order.domain.item;

import com.example.order.domain.item.option.ItemOption;
import com.example.order.domain.item.optiongroup.ItemOptionGroup;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

public class ItemInfo {

    @Getter
    @ToString
    public static class Main {

        private final String itemToken;
        private final Long partnerId;
        private final String itemName;
        private final Long itemPrice;
        private final Item.Status status;
        private final List itemOptionGroupList;

        public Main(Item item, List<ItemOptionGroupInfo> itemOptionGroupList) {
            this.itemToken = item.getItemToken();
            this.partnerId = item.getPartnerId();
            this.itemName = item.getItemName();
            this.itemPrice = item.getItemPrice();
            this.status = item.getStatus();
            this.itemOptionGroupList = itemOptionGroupList;
        }

    }

    @Getter
    @ToString
    public static class ItemOptionGroupInfo {

        private final Integer ordering;
        private final String itemOptionGroupName;
        private final List<ItemOptionInfo> itemOptionList;

        public ItemOptionGroupInfo(ItemOptionGroup itemOptionGroup, List<ItemOptionInfo> itemOptionList) {
            this.ordering = itemOptionGroup.getOrdering();
            this.itemOptionGroupName = itemOptionGroup.getItemOptionGroupName();
            this.itemOptionList = itemOptionList;
        }

    }

    @Getter
    @ToString
    public static class ItemOptionInfo {

        private final Integer ordering;
        private final String itemOptionName;
        private final Long itemOptionPrice;

        public ItemOptionInfo(ItemOption itemOption) {
            this.ordering = itemOption.getOrdering();
            this.itemOptionName = itemOption.getItemOptionName();
            this.itemOptionPrice = itemOption.getItemOptionPrice();
        }

    }

}

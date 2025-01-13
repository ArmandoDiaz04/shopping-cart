package com.api.shoppingCart.service;

import com.api.shoppingCart.dto.ItemDTO;
import com.api.shoppingCart.entity.ItemEntity;

import java.util.List;

public interface ItemService {

    ItemEntity toEntity(ItemDTO m);

    List<ItemEntity> toEntityList(List<ItemDTO> items);

    ItemDTO toModel(ItemEntity e);

    List<ItemDTO> toModelList(List<ItemEntity> items);
}

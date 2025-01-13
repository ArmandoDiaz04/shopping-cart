package com.api.shoppingCart.serviceImplement;

import com.api.shoppingCart.dto.ItemDTO;
import com.api.shoppingCart.entity.ItemEntity;
import com.api.shoppingCart.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Override
    public ItemEntity toEntity(ItemDTO m) {
        ItemEntity e = new ItemEntity();
        e.setProduct(m.getItemId()).setPrice(m.getUnitPrice())
                .setQuantity(m.getQuantity());
        return e;
    }

    @Override
    public List<ItemEntity> toEntityList(List<ItemDTO> items) {
        if (Objects.isNull(items)) {
            return Collections.emptyList();
        }
        return items.stream().map(m -> toEntity(m)).collect(Collectors.toList());
    }

    @Override
    public ItemDTO toModel(ItemEntity e) {
        ItemDTO m = new ItemDTO();
        m.itemId(e.getProduct()).unitPrice(e.getPrice()).quantity(e.getQuantity())
                .description("a description").name("a name")
                .imageUrl("Url Image");//TODO: set name, image url and description of the products
        return m;
    }

    @Override
    public List<ItemDTO> toModelList(List<ItemEntity> items) {
        if (Objects.isNull(items)) {
            return Collections.emptyList();
        }
        return items.stream().map(e -> toModel(e)).collect(Collectors.toList());
    }
}


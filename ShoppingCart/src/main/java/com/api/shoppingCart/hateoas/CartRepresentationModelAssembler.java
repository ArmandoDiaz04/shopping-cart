package com.api.shoppingCart.hateoas;

import com.api.shoppingCart.controller.CartRestController;
import com.api.shoppingCart.dto.CartDTO;
import com.api.shoppingCart.entity.CartEntity;
import com.api.shoppingCart.service.ItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CartRepresentationModelAssembler extends RepresentationModelAssemblerSupport<CartEntity, CartDTO> {

    private ItemService itemService;

    /**
     * Creates a new {@link RepresentationModelAssemblerSupport} using the given
     * controller class and
     * resource type.
     */
    public CartRepresentationModelAssembler(ItemService itemService) {
        super(CartRestController.class, CartDTO.class);
        this.itemService = itemService;
    }

    /**
     * Coverts the Card entity to resource
     *
     * @param entity
     */
    @Override
    public CartDTO toModel(CartEntity entity) {
        String uid = Objects.nonNull(entity.getUser()) ? entity.getUser().getUserId().toString() : null;
        String cid = Objects.nonNull(entity.getCartId()) ? entity.getCartId().toString() : null;
        CartDTO resource = new CartDTO();
        BeanUtils.copyProperties(entity, resource);
        if (uid != null) {
            resource.cardId(cid).customerId(uid).items(itemService.toModelList(entity.getItems()));
            resource.add(linkTo(methodOn(CartRestController.class).getCartByCustomerId(uid)).withSelfRel());
            resource.add(linkTo(methodOn(CartRestController.class).getCartItemsByCustomerId(uid.toString()))
                    .withRel("cart-items"));
        }
        return resource;
    }

    /**
     * Coverts the collection of Product entities to list of resources.
     *
     * @param entities
     */
    public List<CartDTO> toListModel(Iterable<CartEntity> entities) {
        if (Objects.isNull(entities)) {
            return Collections.emptyList();
        }
        return StreamSupport.stream(entities.spliterator(), false).map(e -> toModel(e))
                .collect(Collectors.toList());
    }

}

package com.api.shoppingCart.hateoas;


import com.api.shoppingCart.controller.PaymentRestController;
import com.api.shoppingCart.dto.AuthorizationDTO;
import com.api.shoppingCart.entity.AuthorizationEntity;
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
public class PaymentRepresentationModelAssembler
        extends RepresentationModelAssemblerSupport<AuthorizationEntity, AuthorizationDTO> {

    /**
     * Creates a new {@link RepresentationModelAssemblerSupport} using the given
     * controller class and
     * resource type.
     */
    public PaymentRepresentationModelAssembler() {
        super(PaymentRestController.class, AuthorizationDTO.class);
    }

    /**
     * Coverts the Payment entity to resource
     *
     * @param entity
     */
    @Override
    public AuthorizationDTO toModel(AuthorizationEntity entity) {
        AuthorizationDTO resource = createModelWithId(entity.getId(), entity);
        BeanUtils.copyProperties(entity, resource);
        resource.setId(entity.getId().toString());
        // Self link generated by createModelWithId has missing api path. Therefore
        // generating additionally.
        // can be removed once fixed.
        resource.add(linkTo(
                methodOn(PaymentRestController.class).getOrdersPaymentAuthorization(entity.getId().toString()))
                .withSelfRel());
        return resource;
    }

    /**
     * Coverts the collection of Payment entities to list of resources.
     *
     * @param entities
     */
    public List<AuthorizationDTO> toListModel(Iterable<AuthorizationEntity> entities) {
        if (Objects.isNull(entities)) {
            return Collections.emptyList();
        }
        return StreamSupport.stream(entities.spliterator(), false).map(e -> toModel(e))
                .collect(Collectors.toList());
    }

}

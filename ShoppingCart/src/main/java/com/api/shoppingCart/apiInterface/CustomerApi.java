package com.api.shoppingCart.apiInterface;

import com.api.shoppingCart.dto.CardDTO;
import com.api.shoppingCart.dto.UserDTO;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@Validated
@Api(value = "Customer", description = "the Customer API")
public interface CustomerApi {

    public static final String MEDIA_TYPE = "application/json";

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @ApiOperation(value = "Returns all customers", nickname = "getAllCustomers", notes = "Returns all customers, or empty collection if no use found", response = UserDTO.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "For successful fetch.", response = UserDTO.class, responseContainer = "List") })
    @GetMapping(value = "/customers", produces = { MEDIA_TYPE })
    default ResponseEntity<List<UserDTO>> getAllCustomers() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf(MEDIA_TYPE))) {
                    String exampleJson = "{ \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"password\" : \"password\", \"userStatus\" : \"userStatus\", \"phone\" : \"phone\", \"cardId\" : \"cardId\", \"userId\" : \"userId\", \"email\" : \"email\", \"username\" : \"username\" }";
                    ApiUtil.setExampleResponse(request, MEDIA_TYPE, exampleJson);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    @ApiOperation(value = "Returns a customer", nickname = "getCustomerById", notes = "Returns a customers identifiable by given ID", response = UserDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "For successful fetch.", response = UserDTO.class) })
    @GetMapping(value = "/customers/{id}", produces = { MEDIA_TYPE })
    default ResponseEntity<UserDTO> getCustomerById(
            @ApiParam(value = "Customer Identifier", required = true) @PathVariable("id") String id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf(MEDIA_TYPE))) {
                    String exampleJson = "{ \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"password\" : \"password\", \"userStatus\" : \"userStatus\", \"phone\" : \"phone\", \"cardId\" : \"cardId\", \"userId\" : \"userId\", \"email\" : \"email\", \"username\" : \"username\" }";
                    ApiUtil.setExampleResponse(request, MEDIA_TYPE, exampleJson);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @ApiOperation(value = "Returns all customer's cards", nickname = "getCardByCustomerId", notes = "Returns all customer's cards based on given customer ID", response = CardDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "For successful fetch.", response = CardDTO.class) })
    @GetMapping(value = "/customers/{cardId}/cards", produces = { MEDIA_TYPE })
    default ResponseEntity<CardDTO> getCardByCustomerId(
            @ApiParam(value = "Customer Identifier", required = true) @PathVariable("cardId") String cardId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf(MEDIA_TYPE))) {
                    String exampleJson = "{ \"expires\" : \"expires\", \"cvv\" : \"cvv\", \"cardId\" : \"cardId\", \"userId\" : \"userId\", \"cardNumber\" : \"cardNumber\" }";
                    ApiUtil.setExampleResponse(request, MEDIA_TYPE, exampleJson);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    @ApiOperation(value = "Deletes the customer", nickname = "deleteCustomerById", notes = "Deletes the customer identifiable by given ID")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Request accepted, returns this status even if user does not exist") })
    @DeleteMapping(value = "/customers/{id}")
    default ResponseEntity<Void> deleteCustomerById(
            @ApiParam(value = "Customer Identifier", required = true) @PathVariable("id") String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}


package com.api.shoppingCart.apiInterface;

import com.api.shoppingCart.dto.CartDTO;
import com.api.shoppingCart.dto.ItemDTO;
import io.swagger.annotations.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@Validated
@Api(value = "Cart", description = "the Cart API")
public interface CartApi {

    public static final String MEDIA_TYPE = "application/json";

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @ApiOperation(value = "Returns the shopping cart", nickname = "getCartByCustomerId", notes = "Returns the shopping cart of given customer identifier", response = CartDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = CartDTO.class),
            @ApiResponse(code = 404, message = "Given customer ID doesn't exist") })
    @GetMapping(value = "/carts/{customerId}", produces = { MEDIA_TYPE })
    default ResponseEntity<CartDTO> getCartByCustomerId(
            @ApiParam(value = "Customer Identifier", required = true) @PathVariable("customerId") String customerId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf(MEDIA_TYPE))) {
                    String exampleString = "{ \"cartId\" : \"cartId\", \"customerId\" : \"customerId\", \"items\" : [ { \"itemId\" : \"itemId\", \"unitPrice\" : 0.0, \", \"quantity\" : 0, \"imageUrl\" : \"imageUrl\", \"name\" : \"name\", \"description\" : \"description\"}, { \"itemId\" : \"itemId\", \"unitPrice\" : 0.0, \", \"quantity\" : 0, \"imageUrl\" : \"imageUrl\", \"name\" : \"name\", \"description\" : \"description\" } ] }";
                    ApiUtil.setExampleResponse(request, MEDIA_TYPE, exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    @ApiOperation(value = "Returns the list of products in user's shopping cart", nickname = "getCartItemsByCustomerId", notes = "Returns the items in shopping cart of given customer", response = ItemDTO.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = ItemDTO.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Given customer ID doesn't exist") })
    @GetMapping(value = "/carts/{customerId}/items", produces = { MEDIA_TYPE })
    default ResponseEntity<List<ItemDTO>> getCartItemsByCustomerId(
            @ApiParam(value = "Customer Identifier", required = true) @PathVariable("customerId") String customerId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf(MEDIA_TYPE))) {
                    String exampleString = "{ \"itemId\" : \"itemId\", \"unitPrice\" : 0.0, \", \"quantity\" : 0, \"imageUrl\" : \"imageUrl\", \"name\" : \"name\", \"description\" : \"description\" }";
                    ApiUtil.setExampleResponse(request, MEDIA_TYPE, exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    @ApiOperation(value = "Returns given item from user's shopping cart", nickname = "getCartItemsByItemId", notes = "Returns given item from shopping cart of given customer", response = ItemDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "If item exists in cart", response = ItemDTO.class),
            @ApiResponse(code = 404, message = "Given item (product) ID doesn't exist") })
    @GetMapping(value = "/carts/{customerId}/items/{itemId}", produces = { MEDIA_TYPE })
    default ResponseEntity<ItemDTO> getCartItemsByItemId(
            @ApiParam(value = "Customer Identifier", required = true) @PathVariable("customerId") String customerId,
            @ApiParam(value = "Item (product) Identifier", required = true) @PathVariable("itemId") Integer itemId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf(MEDIA_TYPE))) {
                    String exampleString = "{ \"itemId\" : \"itemId\", \"unitPrice\" : 0.0, \", \"quantity\" : 0, \"imageUrl\" : \"imageUrl\", \"name\" : \"name\", \"description\" : \"description\" }";
                    ApiUtil.setExampleResponse(request, MEDIA_TYPE, exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    @ApiOperation(value = "Adds an item in shopping cart", nickname = "addCartItemsByCustomerId", notes = "Adds an item to the shopping cart if it doesn't already exist.", response = ItemDTO.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Item added successfully", response = ItemDTO.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Given customer ID doesn't exist") })
    @PostMapping(value = "/carts/{customerId}/items", produces = { MEDIA_TYPE }, consumes = { MEDIA_TYPE })
    default ResponseEntity<List<ItemDTO>> addCartItemsByCustomerId(
            @ApiParam(value = "Customer Identifier", required = true) @PathVariable("customerId") String customerId,
            @ApiParam(value = "Item object") @Valid @RequestBody(required = false) ItemDTO item) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf(MEDIA_TYPE))) {
                    String exampleString = "{ \"itemId\" : \"itemId\", \"unitPrice\" : \"\", \"quantity\" : 0, \"imageUrl\" : \"imageUrl\", \"name\" : \"name\", \"description\" : \"description\" }";
                    ApiUtil.setExampleResponse(request, MEDIA_TYPE, exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    @ApiOperation(value = "Replace/add an item in shopping cart", nickname = "addOrReplaceItemsByCustomerId", notes = "Adds an item to the shopping cart if it doesn't already exist, or replace it with the given item.", response = ItemDTO.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Items list updated successfully", response = ItemDTO.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Given customer ID doesn't exist") })
    @PutMapping(value = "/carts/{customerId}/items", produces = { MEDIA_TYPE }, consumes = { MEDIA_TYPE })
    default ResponseEntity<List<ItemDTO>> addOrReplaceItemsByCustomerId(
            @ApiParam(value = "Customer Identifier", required = true) @PathVariable("customerId") String customerId,
            @ApiParam(value = "Item object") @Valid @RequestBody(required = false) ItemDTO item) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf(MEDIA_TYPE))) {
                    String exampleString = "{ \"unitPrice\" : 0.0, \", \"quantity\" : 0, \"imageUrl\" : \"imageUrl\", \"name\" : \"name\", \"description\" : \"description\", \"itemId\" : \"itemId\" }";
                    ApiUtil.setExampleResponse(request, MEDIA_TYPE, exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    @ApiOperation(value = "Delete the item from shopping cart", nickname = "deleteItemFromCart", notes = "Deletes the item from shopping cart of given customer")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Accepts the request, regardless of whether the specified item exists in the cart or not.") })
    @DeleteMapping(value = "/carts/{customerId}/items/{itemId}")
    default ResponseEntity<Void> deleteItemFromCart(
            @ApiParam(value = "Customer Identifier", required = true) @PathVariable("customerId") String customerId,
            @ApiParam(value = "Item (product) Identifier", required = true) @PathVariable("itemId") Integer itemId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    @ApiOperation(value = "Delete the shopping cart", nickname = "deleteCart", notes = "Deletes the shopping cart of given customer")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "successful operation"),
            @ApiResponse(code = 404, message = "Given customer ID doesn't exist") })
    @DeleteMapping(value = "/carts/{customerId}")
    default ResponseEntity<Void> deleteCart(
            @ApiParam(value = "Customer Identifier", required = true) @PathVariable("customerId") String customerId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }
}

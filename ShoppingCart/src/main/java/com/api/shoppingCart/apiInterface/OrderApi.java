package com.api.shoppingCart.apiInterface;

import com.api.shoppingCart.dto.NewOrderDTO;
import com.api.shoppingCart.dto.OrderDTO;
import io.swagger.annotations.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@Validated
@Api(value = "Order", description = "the Order API")
public interface OrderApi {

    public static final String MEDIA_TYPE = "application/json";

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @ApiOperation(value = "Creates a new order for the given order request", nickname = "addOrder", notes = "Creates a new order for the given order request.", response = OrderDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Order added successfully", response = OrderDTO.class),
            @ApiResponse(code = 401, message = "If payment is not authorized.") })
    @PostMapping(
            value = "/orders",
            produces = { MEDIA_TYPE },
            consumes = { MEDIA_TYPE }
    )
    default ResponseEntity<OrderDTO> addOrder(@ApiParam(value = "New Order Request object"  )  @Valid @RequestBody(required = false) NewOrderDTO newOrder) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf(MEDIA_TYPE))) {
                    String exampleString = "{ \"date\" : \"2000-01-23T04:56:07.000+00:00\", \"total\" : \"\", \"payment\" : { \"authorized\" : true, \"paymentId\" : \"paymentId\", \"message\" : \"message\" }, \"orderId\" : \"orderId\", \"items\" : [ { \"unitPrice\" : \"\", \"quantity\" : 0, \"imageUrl\" : \"imageUrl\", \"name\" : \"name\", \"description\" : \"description\", \"id\" : \"id\" }, { \"unitPrice\" : \"\", \"quantity\" : 0, \"imageUrl\" : \"imageUrl\", \"name\" : \"name\", \"description\" : \"description\", \"itemId\" : \"itemId\" } ], \"card\" : { \"expires\" : \"expires\", \"cvv\" : \"cvv\", \"cardId\" : \"cardId\", \"userId\" : \"userId\", \"cardNumber\" : \"cardNumber\" }, \"customer\" : { \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"password\" : \"password\", \"userStatus\" : \"userStatus\", \"phone\" : \"phone\", \"cardId\" : \"cardId\", \"userId\" : \"userId\", \"email\" : \"email\", \"username\" : \"username\" }, \"status\" : \"CREATED\" }";
                    ApiUtil.setExampleResponse(request, MEDIA_TYPE, exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    @ApiOperation(value = "Returns the order of given order ID", nickname = "getByOrderId", notes = "Returns orders of given order ID", response = OrderDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "If order exists.", response = OrderDTO.class),
            @ApiResponse(code = 404, message = "Order doesn't exist for given user.") })
    @GetMapping(
            value = "/orders/{id}",
            produces = { MEDIA_TYPE }
    )
    default ResponseEntity<OrderDTO> getByOrderId(@ApiParam(value = "Order Identifier",required=true) @PathVariable("id") String id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf(MEDIA_TYPE))) {
                    String exampleString = "{ \"date\" : \"2000-01-23T04:56:07.000+00:00\", \"total\" : \"\", \"payment\" : { \"authorized\" : true, \"paymentId\" : \"paymentId\", \"message\" : \"message\" }, \"orderId\" : \"orderId\", \"items\" : [ { \"unitPrice\" : \"\", \"quantity\" : 0, \"imageUrl\" : \"imageUrl\", \"name\" : \"name\", \"description\" : \"description\", \"itemId\" : \"itemId\" }, { \"unitPrice\" : \"\", \"quantity\" : 0, \"imageUrl\" : \"imageUrl\", \"name\" : \"name\", \"description\" : \"description\", \"itemId\" : \"itemId\" } ], \"card\" : { \"expires\" : \"expires\", \"cvv\" : \"cvv\", \"cardId\" : \"cardId\", \"userId\" : \"userId\", \"cardNumber\" : \"cardNumber\" }, \"customer\" : { \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"password\" : \"password\", \"userStatus\" : \"userStatus\", \"phone\" : \"phone\", \"cardId\" : \"cardId\", \"userId\" : \"userId\", \"email\" : \"email\", \"username\" : \"username\" }, \"status\" : \"CREATED\" }";
                    ApiUtil.setExampleResponse(request, MEDIA_TYPE, exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    @ApiOperation(value = "Returns the orders of given user identifier", nickname = "getOrdersByCustomerId", notes = "Returns orders of given user identifier", response = OrderDTO.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "If order exists.", response = OrderDTO.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Order doesn't exist for given user.") })
    @GetMapping(
            value = "/orders",
            produces = { MEDIA_TYPE }
    )
    default ResponseEntity<List<OrderDTO>> getOrdersByCustomerId(@NotNull @ApiParam(value = "Customer Identifier", required = true) @Valid @RequestParam(value = "customerId", required = true) String customerId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf(MEDIA_TYPE))) {
                    String exampleString = "{ \"date\" : \"2000-01-23T04:56:07.000+00:00\", \"total\" : \"\", \"payment\" : { \"authorized\" : true, \"paymentId\" : \"paymentId\", \"message\" : \"message\" }, \"orderId\" : \"orderId\", \"items\" : [ { \"unitPrice\" : \"\", \"quantity\" : 0, \"imageUrl\" : \"imageUrl\", \"name\" : \"name\", \"description\" : \"description\", \"itemId\" : \"itemId\" }, { \"unitPrice\" : \"\", \"quantity\" : 0, \"imageUrl\" : \"imageUrl\", \"name\" : \"name\", \"description\" : \"description\", \"itemId\" : \"itemId\" } ], \"card\" : { \"expires\" : \"expires\", \"cvv\" : \"cvv\", \"cardId\" : \"cardId\", \"userId\" : \"userId\", \"cardNumber\" : \"cardNumber\" }, \"customer\" : { \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"password\" : \"password\", \"userStatus\" : \"userStatus\", \"phone\" : \"phone\", \"cardId\" : \"cardId\", \"userId\" : \"userId\", \"email\" : \"email\", \"username\" : \"username\" }, \"status\" : \"CREATED\" }";
                    ApiUtil.setExampleResponse(request, MEDIA_TYPE, exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }
}


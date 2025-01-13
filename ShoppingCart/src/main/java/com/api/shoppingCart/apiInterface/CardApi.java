package com.api.shoppingCart.apiInterface;

import com.api.shoppingCart.dto.CardDTO;
import io.swagger.annotations.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@Validated
@Api(value = "Card", description = "The Card API")
public interface CardApi {

    public static final String MEDIA_TYPE = "application/json";

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     *
     * @return a list of cards
     */
    @ApiOperation(value = "Returns all user's cards", nickname = "getAllCards", notes = "Returns all user's cards, else empty collection", response = CardDTO.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "For successful fetch.", response = CardDTO.class, responseContainer = "List") })
    @RequestMapping(value = "/cards", produces = { MEDIA_TYPE }, method = RequestMethod.GET)
    default ResponseEntity<List<CardDTO>> getAllCards() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf(MEDIA_TYPE))) {
                    String exampleString = "{ \"cardId\" : \"cardId\", \"cardNumber\" : \"cardNumber\", \"expires\" : \"expires\", \"cvv\" : \"cvv\", \"userId\" : \"userId\" }";
                    ApiUtil.setExampleResponse(request, MEDIA_TYPE, exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     *
     * @param ID of the requested card
     * @return a card
     */
    @ApiOperation(value = "Returns user's card", nickname = "getCardById", notes = "Returns user's card based on given card ID.", response = CardDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "For successful fetch.", response = CardDTO.class),
            @ApiResponse(code = 404, message = "If a card with the requested id does not exist.") })
    @RequestMapping(value = "/cards/{id}", produces = { MEDIA_TYPE }, method = RequestMethod.GET)
    default ResponseEntity<CardDTO> getCardById(
            @ApiParam(value = "card Identifier", required = true) @PathVariable("id") String id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf(MEDIA_TYPE))) {
                    ApiUtil.setExampleResponse(request, MEDIA_TYPE,
                            "{ \"cardId\" : \"cardId\", \"expires\" : \"expires\",  \"ccv\" : \"ccv\",  \"cardNumber\" : \"cardNumber\", \"userId\" : \"userId\"}");
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     *
     * @param information of the new card to persist
     * @return the new card persisted
     */
    @ApiOperation(value = "Creates a new user card", nickname = "registerCard", notes = "Creates a new user addresses. Does nothing if address already exists.", response = CardDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "For successful fetch.", response = CardDTO.class),
            @ApiResponse(code = 406, message = "If the card number is already registered.") })
    @RequestMapping(value = "/cards", produces = { MEDIA_TYPE }, consumes = { MEDIA_TYPE }, method = RequestMethod.POST)
    default ResponseEntity<CardDTO> registerCard(
            @ApiParam(value = "card information") @Valid @RequestBody(required = false) CardDTO newCard) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf(MEDIA_TYPE))) {
                    String exampleString = "{ \"cardId\" : \"cardId\", \"cardNumber\" : \"cardNumber\", \"expires\" : \"expires\", \"cvv\" : \"cvv\", \"userId\" : \"userId\" }";
                    ApiUtil.setExampleResponse(request, MEDIA_TYPE, exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     *
     * @param id card Identifier (required)
     * @return Accepts the deletion request and perform deletion. If ID does not
     *         exist, does nothing. (status code 202)
     */
    @ApiOperation(value = "Deletes a card", nickname = "deleteCardById", notes = "Delete a card based on the given card ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Accepts the deletion request and perform deletion. If ID does not exist, does nothing."),
            @ApiResponse(code = 404, message = "If a card with the requested id does not exist.")
    })
    @RequestMapping(value = "/cards/{id}", method = RequestMethod.DELETE)
    default ResponseEntity<Void> deleteCardById(
            @ApiParam(value = "card Identifier", required = true) @PathVariable("id") String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}


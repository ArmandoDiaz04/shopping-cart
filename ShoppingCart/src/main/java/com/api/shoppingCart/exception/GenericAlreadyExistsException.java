package com.api.shoppingCart.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Generic exception thrown when there is an attempt to create an entity with a
 * unique code that already exists.
 */
@Getter
@Setter
public class GenericAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final String errMsgKey;
    private final String errorCode;

    public GenericAlreadyExistsException(ErrorCode code) {
        super(code.getErrMsgKey());
        this.errMsgKey = code.getErrMsgKey();
        this.errorCode = code.getErrCode();
    }

    public GenericAlreadyExistsException(final String message) {
        super(message);
        this.errMsgKey = ErrorCode.RESOURCE_NOT_FOUND.getErrMsgKey();
        this.errorCode = ErrorCode.RESOURCE_NOT_FOUND.getErrCode();
    }
    public String getErrorCode() {
        return errorCode;
    }
}

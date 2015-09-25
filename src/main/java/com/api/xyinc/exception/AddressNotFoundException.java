package com.api.xyinc.exception;


public class AddressNotFoundException extends ServiceException {

    private static final long serialVersionUID = 1455787247510842345L;

    public AddressNotFoundException() {
    }

    public AddressNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }


    public AddressNotFoundException(final String message) {
        super(message);
    }


    public AddressNotFoundException(final Throwable cause) {
        super(cause);
    }

}

package com.tiendaPatito.caomioneta.OrdenCamioneta.exceptions;


public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
package com.salesianos.ejemploSeguridad02.security.errorhanding;

public class JwtTokenException extends RuntimeException{

    public JwtTokenException(String msg) {
        super(msg);
    }


}

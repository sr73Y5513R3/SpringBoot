package com.salesianos.ejemploSeguridad02.security.jwt.refresh;


import com.salesianos.ejemploSeguridad02.security.errorhanding.JwtTokenException;

public class RefreshTokenException extends JwtTokenException {

    public RefreshTokenException(String msg) {
        super(msg);
    }

}

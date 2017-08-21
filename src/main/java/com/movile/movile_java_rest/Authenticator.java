package com.movile.movile_java_rest;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.MultivaluedMap;

public class Authenticator implements ClientRequestFilter {

    private final String userName;
    private final String authentication;

    public Authenticator(String UserName, String authentication) {
        this.userName = UserName;
        this.authentication = authentication;
    }

    public void filter(ClientRequestContext requestContext) throws IOException {
        MultivaluedMap<String, Object> headers = requestContext.getHeaders();

        headers.add("AuthenticationToken", authentication);
        headers.add("UserName", userName);
    }

}

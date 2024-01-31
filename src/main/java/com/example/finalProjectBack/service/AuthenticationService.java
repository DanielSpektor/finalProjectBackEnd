package com.example.finalProjectBack.service;

import com.example.finalProjectBack.security.model.AuthenticationRequest;
import com.example.finalProjectBack.security.model.AuthenticationResponse;

public interface AuthenticationService {

    AuthenticationResponse createAuthenticationToken(AuthenticationRequest authenticationRequest) throws Exception;
}

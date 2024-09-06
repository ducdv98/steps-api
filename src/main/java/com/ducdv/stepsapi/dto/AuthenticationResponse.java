package com.ducdv.stepsapi.dto;

import lombok.Data;

@Data
public class AuthenticationResponse {
    private String accessToken;

    public AuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}

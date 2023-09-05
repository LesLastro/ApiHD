package com.cev.sircapcev.security.securityDTO;

public class JwtTokenDTO {
    private String token;


    public JwtTokenDTO() {
    }


    public JwtTokenDTO(String token) {
        this.token = token;
    }


    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}

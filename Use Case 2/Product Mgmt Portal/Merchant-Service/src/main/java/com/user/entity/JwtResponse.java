package com.user.entity;

public class JwtResponse {

    private Merchant user;
    private String jwtToken;

    public JwtResponse(Merchant user, String jwtToken) {
        this.user = user;
        this.jwtToken = jwtToken;
    }

    public Merchant getUser() {
        return user;
    }

    public void setUser(Merchant user) {
        this.user = user;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}

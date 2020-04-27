package com.rk.movieland.domain;

public enum Roles {
    ADMIN, USER, GUEST;

    public String getRole() {
        return name();
    }


}

package com.movieland.domian;

public enum Roles {
    ADMIN, USER;

    public String getRole() {
        return name();
    }
}

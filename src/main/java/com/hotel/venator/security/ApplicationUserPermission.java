package com.hotel.venator.security;

public enum ApplicationUserPermission {
	
	USER_READ("user:read"),
    USER_WRITE("user:write"),
    USER_UPDATE("user:update"),
    USER_DELETE("user:delete"),
    BOOKING_READ("booking:read"),
    BOOKING_WRITE("booking:write"),
    BOOKING_UPDATE("booking:update"),
    BOOKING_DELETE("booking:delete");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }

}

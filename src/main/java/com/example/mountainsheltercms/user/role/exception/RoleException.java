package com.example.mountainsheltercms.user.role.exception;

import com.example.mountainsheltercms.user.exception.UserError;

public class RoleException extends RuntimeException{

    private RoleError roleError;

    public RoleException(RoleError roleError) {
        this.roleError = roleError;
    }

    public RoleError getRoleError() {
        return roleError;
    }
}

package kr.kro.srvrstudy.srvr_auth.domain.model;

import kr.kro.srvrstudy.srvr_auth.persist.entity.UserEntity;
import kr.kro.srvrstudy.srvr_auth.persist.entity.UserRole;
import kr.kro.srvrstudy.srvr_common.helper.Assert;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private final String username;
    private final UserRole role;
    private final String email;

    public User(String username, UserRole role, String email) {
        Assert.notEmpty(username, "username can't be empty");
        Assert.notNull(role, "role can't be null");
        Assert.notEmpty(email, "email can't be empty");

        this.username = username;
        this.role = role;
        this.email = email;
    }

    public static User from(UserEntity entity) {
        return new User(entity.getUsername(), entity.getRole(), entity.getEmail());
    }
}

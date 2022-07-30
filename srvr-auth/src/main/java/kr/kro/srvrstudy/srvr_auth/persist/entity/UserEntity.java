package kr.kro.srvrstudy.srvr_auth.persist.entity;

import kr.kro.srvrstudy.srvr_auth.persist.entity.converter.UserRoleConverter;
import kr.kro.srvrstudy.srvr_common.dto.JoinDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class UserEntity {

    @Id
    @Size(min = 4, max = 16)
    @Column(name = "username", nullable = false)
    private String username;

    @Size(min = 44, max = 44)
    @NotBlank
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    @Convert(converter = UserRoleConverter.class)
    private UserRole role;

    @Pattern(regexp = "^\\w+@\\w+\\.\\w+(\\.\\w+)?")
    @Column(name = "email", nullable = false)
    private String email;

    @CreatedDate
    private LocalDateTime createdAt;

    public UserEntity(JoinDTO.Req req) {
        username = req.getUsername();
        password = req.getPassword();
        email = req.getEmail();
        role = UserRole.from(req.getRole());
    }
}

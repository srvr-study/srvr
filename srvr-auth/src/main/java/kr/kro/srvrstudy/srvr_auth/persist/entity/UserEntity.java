package kr.kro.srvrstudy.srvr_auth.persist.entity;

import kr.kro.srvrstudy.srvr_common.dto.auth.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private String username;

    @Size(min = 4, max = 16)
    @NotBlank
    private String password;

    @Pattern(regexp = "^\\w+@\\w+\\.\\w+(\\.\\w+)?")
    private String email;

    @CreatedDate
    private LocalDateTime createdAt;

    public UserEntity(UserDTO.JoinReq req) {
        username = req.getUsername();
        password = req.getPassword();
        email = req.getEmail();
    }
}

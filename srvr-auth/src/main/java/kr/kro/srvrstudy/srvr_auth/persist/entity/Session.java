package kr.kro.srvrstudy.srvr_auth.persist.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "session")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class Session {

    @Id
    @Column(name = "session_key")
    private String sessionKey;

    @Column(name = "username")
    private String username;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Session(String sessionKey, String username, LocalDateTime lastLoggedInAt) {
        this.sessionKey = sessionKey;
        this.username = username;
        this.createdAt = lastLoggedInAt;
    }
}

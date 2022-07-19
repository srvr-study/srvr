package kr.kro.srvrstudy.srvr_auth.persist.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "session")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class Session {

    @Id
    private String sessionKey;
}

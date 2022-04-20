package kr.kro.srvrstudy.srvr_main.persist.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;

@EntityListeners(AuditingEntityListener.class)
public interface Auditing {
}

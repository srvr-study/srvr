package kr.kro.srvrstudy.srvr_auth.persist.repository;

import kr.kro.srvrstudy.srvr_auth.persist.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session, String> {
}

package kr.kro.srvrstudy.srvr_auth.persist.repository;

import kr.kro.srvrstudy.srvr_auth.persist.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findUserEntityByEmail(String email);
}

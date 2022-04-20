package kr.kro.srvrstudy.srvr_main.persist.repository;

import kr.kro.srvrstudy.srvr_main.persist.entity.FeatureServerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FeatureServerRepository extends JpaRepository<FeatureServerEntity, Long> {

    Optional<FeatureServerEntity> findByName(String name);

    Optional<FeatureServerEntity> findByHost(String host);

}

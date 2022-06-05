package kr.kro.srvrstudy.srvr_main.persist.repository;

import kr.kro.srvrstudy.srvr_main.persist.entity.FeatureServerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FeatureServerRepository extends JpaRepository<FeatureServerEntity, Long> {

    @Query("select f from FeatureServerEntity f left join fetch f.featureServerTags")
    List<FeatureServerEntity> findAll();

    @Query("select f from FeatureServerEntity f left join fetch f.featureServerTags order by f.name")
    List<FeatureServerEntity> findAllByOrderByName();

    Optional<FeatureServerEntity> findByName(String name);

    Optional<FeatureServerEntity> findByHost(String host);

}

package kr.kro.srvrstudy.srvr_main.persist.repository;

import kr.kro.srvrstudy.srvr_main.persist.entity.FeatureServerTagEntity;
import kr.kro.srvrstudy.srvr_main.persist.entity.FeatureServerTagPk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeatureServerTagRepository extends JpaRepository<FeatureServerTagEntity, FeatureServerTagPk> {

    List<FeatureServerTagEntity> findAllByPk_FeatureServerId(Long featureServerId);

}

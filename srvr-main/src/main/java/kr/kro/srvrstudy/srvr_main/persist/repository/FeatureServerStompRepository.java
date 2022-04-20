package kr.kro.srvrstudy.srvr_main.persist.repository;

import kr.kro.srvrstudy.srvr_main.domain.model.FeatureServer;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class FeatureServerStompRepository {

    private ConcurrentHashMap<String, FeatureServer> featureServerMap;

    @PostConstruct
    private void init(){
        featureServerMap = new ConcurrentHashMap<>();
    }

    public List<FeatureServer> findAll() {
        return new ArrayList<>(featureServerMap.values());
    }

    public FeatureServer updateFeatureServer(FeatureServer featureServer){
        this.featureServerMap.put(featureServer.getName(), featureServer);
        return featureServer;
    }

}

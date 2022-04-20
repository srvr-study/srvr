package kr.kro.srvrstudy.srvr_main.persist.repository;

import kr.kro.srvrstudy.srvr_main.domain.model.FeatureServer;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
<<<<<<< HEAD
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
=======
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
>>>>>>> 759882c (feat: STOMP 설정 및 간단 스케쥴러 추가 및 패키지 구조 정립)

@Repository
public class FeatureServerStompRepository {

<<<<<<< HEAD
    private final FeatureServerRepository featureServerRepository;
    private final ConcurrentHashMap<String, FeatureServer> featureServerMap;

    public FeatureServerStompRepository(FeatureServerRepository featureServerRepository) {
        this.featureServerRepository = featureServerRepository;
        this.featureServerMap = new ConcurrentHashMap<>();
    }

    @PostConstruct
    public void init() {
        this.updateAll(featureServerRepository.findAll()
                                              .stream()
                                              .map(FeatureServer::of)
                                              .collect(Collectors.toList()));
=======
    private ConcurrentHashMap<String, FeatureServer> featureServerMap;

    @PostConstruct
    private void init(){
        featureServerMap = new ConcurrentHashMap<>();
>>>>>>> 759882c (feat: STOMP 설정 및 간단 스케쥴러 추가 및 패키지 구조 정립)
    }

    public List<FeatureServer> findAll() {
        return new ArrayList<>(featureServerMap.values());
    }

<<<<<<< HEAD
    public void updateFeatureServer(FeatureServer featureServer) {
        this.featureServerMap.put(featureServer.getName(), featureServer);
    }

    public void updateAll(Collection<FeatureServer> collection) {
        collection.forEach(featureServer -> featureServerMap.merge(featureServer.getName(), featureServer, (o, n) -> n));
    }

    public void deleteFeatureServer(String featureServerName) {
        this.featureServerMap.remove(featureServerName);
=======
    public FeatureServer updateFeatureServer(FeatureServer featureServer){
        this.featureServerMap.put(featureServer.getName(), featureServer);
        return featureServer;
>>>>>>> 759882c (feat: STOMP 설정 및 간단 스케쥴러 추가 및 패키지 구조 정립)
    }
}

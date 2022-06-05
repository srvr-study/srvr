package kr.kro.srvrstudy.srvr_main.persist.repository;

import kr.kro.srvrstudy.srvr_main.domain.model.FeatureServer;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class FeatureServerStompRepository {

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
    }

    public List<FeatureServer> findAll() {
        return new ArrayList<>(featureServerMap.values());
    }

    public void updateFeatureServer(FeatureServer featureServer) {
        this.featureServerMap.put(featureServer.getName(), featureServer);
    }

    public void updateAll(Collection<FeatureServer> collection) {
        collection.forEach(featureServer -> featureServerMap.merge(featureServer.getName(), featureServer, (o, n) -> n));
    }

    public void deleteFeatureServer(String featureServerName) {
        this.featureServerMap.remove(featureServerName);
    }
}
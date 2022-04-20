package kr.kro.srvrstudy.srvr_main.domain.service;

import kr.kro.srvrstudy.srvr_main.domain.model.FeatureServer;
import kr.kro.srvrstudy.srvr_main.persist.repository.FeatureServerStompRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FeatureServerService {

    private final FeatureServerStompRepository featureServerStompRepository;

    public List<FeatureServer> getFeatureServers() {
        return featureServerStompRepository.findAll();
    }

    public boolean upsertFeatureServer(FeatureServer featureServer) {
        Optional<FeatureServer> updateFeatureServer = Optional.ofNullable(featureServerStompRepository.updateFeatureServer(featureServer));
        return updateFeatureServer.isPresent();
    }

}

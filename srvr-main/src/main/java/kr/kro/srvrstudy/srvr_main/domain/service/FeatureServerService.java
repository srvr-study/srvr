package kr.kro.srvrstudy.srvr_main.domain.service;

import kr.kro.srvrstudy.srvr_common.exception.ApiFailureException;
import kr.kro.srvrstudy.srvr_common.exception.ErrorCode;
import kr.kro.srvrstudy.srvr_common.helper.IdGenerator;
import kr.kro.srvrstudy.srvr_main.domain.model.FeatureServer;
import kr.kro.srvrstudy.srvr_main.domain.model.FeatureServerRequest;
import kr.kro.srvrstudy.srvr_common.helper.Validator;
import kr.kro.srvrstudy.srvr_main.persist.entity.FeatureServerEntity;
import kr.kro.srvrstudy.srvr_main.persist.repository.FeatureServerRepository;
import kr.kro.srvrstudy.srvr_main.persist.repository.FeatureServerStompRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FeatureServerService {

    private final FeatureServerStompRepository featureServerStompRepository;
    private final FeatureServerRepository featureServerRepository;

    @Transactional(readOnly = true)
    public FeatureServer getByFeatureServerName(String name) {
        return featureServerRepository.findByName(name)
                .map(FeatureServer::of)
                .orElseThrow(() -> new ApiFailureException(ErrorCode.INVALID_REQUEST));
    }

    public List<FeatureServer> getFeatureServers() {
        return featureServerRepository.findAllByOrderByName().stream()
                .map(FeatureServer::of)
                .collect(Collectors.toList());
    }

    public List<FeatureServer> getRealTimeFeatureServers() {
        return featureServerStompRepository.findAll();
    }

    @Transactional
    public void createFeatureServer(FeatureServerRequest featureServerRequest) {
        Validator.validateEmpty(featureServerRequest.getName(), this.featureServerRepository::findByName);
        Validator.validateEmpty(featureServerRequest.getUrl(), this.featureServerRepository::findByUrl);

        FeatureServerEntity newFeatureServerEntity = FeatureServerEntity.builder()
                .featureServerId(IdGenerator.generate())
                .url(featureServerRequest.getUrl())
                .name(featureServerRequest.getName())
                .description(featureServerRequest.getDescription())
                .creatorMemberId(featureServerRequest.getUpdatorMemberId())
                .createdAt(LocalDateTime.now())
                .lastUpdaterMemberId(featureServerRequest.getUpdatorMemberId())
                .build();

        featureServerRepository.saveAndFlush(newFeatureServerEntity);
        featureServerStompRepository.updateFeatureServer(FeatureServer.of(newFeatureServerEntity));
    }

    @Transactional
    public void updateFeatureServer(String featureServerName, FeatureServerRequest featureServer) {
        FeatureServerEntity featureServerEntity = featureServerRepository.findByName(featureServerName)
                                                                         .orElseThrow(() -> new ApiFailureException(ErrorCode.INVALID_REQUEST));

        if (Strings.isBlank(featureServer.getUrl())) {
            featureServerEntity.setUrl(featureServer.getUrl());
        }

        if (Strings.isBlank(featureServer.getName())) {
            featureServerEntity.setName(featureServer.getName());
        }

        if (Strings.isBlank(featureServer.getDescription())) {
            featureServerEntity.setDescription(featureServer.getDescription());
        }

        FeatureServerEntity updateFeatureServer = featureServerRepository.saveAndFlush(featureServerEntity);
        featureServerStompRepository.updateFeatureServer(FeatureServer.of(updateFeatureServer));
    }

    @Transactional
    public void deleteFeatureServer(FeatureServer featureServer) {
        FeatureServerEntity featureServerEntity = featureServerRepository.findByName(featureServer.getName())
                                                                         .orElseThrow(() -> new ApiFailureException(ErrorCode.INVALID_REQUEST));
        featureServerRepository.delete(featureServerEntity);
        featureServerStompRepository.deleteFeatureServer(featureServer.getName());
    }

}
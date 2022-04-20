package kr.kro.srvrstudy.srvr_main.presentation.controller;

import kr.kro.srvrstudy.srvr_common.api.response.ApiResponse;
import kr.kro.srvrstudy.srvr_common.api.response.SuccessResponse;
import kr.kro.srvrstudy.srvr_main.domain.model.FeatureServerTagRequest;
import kr.kro.srvrstudy.srvr_main.domain.model.Tag;
import kr.kro.srvrstudy.srvr_main.domain.service.FeatureServerTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class FeatureServerTagController {

    private final FeatureServerTagService featureServerTagService;

    @GetMapping("/feature-servers/{feature-server-id}/tags")
    public ApiResponse<Tag> getTags(@PathVariable("feature-server-id") Long featureServerId) {
        return new SuccessResponse<>(featureServerTagService.getTags(featureServerId));
    }

    @PostMapping("/feature-servers/{feature-server-id}/tags/{tag-id}")
    public ApiResponse<Void> registerTag(@ModelAttribute("feature-server-tag-request") FeatureServerTagRequest featureServerTagRequest) {
        featureServerTagService.createFeatureServerTag(featureServerTagRequest);
        return new SuccessResponse<>();
    }

    @PatchMapping("/feature-servers/{feature-server-id}/tags/{tag-id}")
    public ApiResponse<Void> setPrimaryTag(@ModelAttribute("feature-server-tag-request") FeatureServerTagRequest featureServerTagRequest) {
        featureServerTagService.updateFeatureServerTag(featureServerTagRequest);
        return new SuccessResponse<>();
    }

    @DeleteMapping("/feature-servers/{feature-server-id}/tags/{tag-id}")
    public ApiResponse<Void> deleteFeatureServerTag(@PathVariable("feature-server-id") Long featureServerId,
                                                    @PathVariable("tag-id") Long tagId) {
        featureServerTagService.deleteFeatureServerTag(featureServerId, tagId);
        return new SuccessResponse<>();
    }

    @ModelAttribute(value = "feature-server-tag-request")
    public FeatureServerTagRequest getFeatureServer(@PathVariable("feature-server-id") Long featureServerId,
                                                    @PathVariable("tag-id") Long tagId,
                                                    @RequestBody FeatureServerTagRequest featureServerTagRequest) {
        featureServerTagRequest.setFeatureServerId(featureServerId);
        featureServerTagRequest.setTagId(tagId);
        return featureServerTagRequest;
    }

}

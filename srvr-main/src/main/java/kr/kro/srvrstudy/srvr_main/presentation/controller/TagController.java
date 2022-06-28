package kr.kro.srvrstudy.srvr_main.presentation.controller;

import kr.kro.srvrstudy.srvr_common.api.response.ApiResponse;
import kr.kro.srvrstudy.srvr_common.api.response.SuccessResponse;
import kr.kro.srvrstudy.srvr_main.domain.model.Tag;
import kr.kro.srvrstudy.srvr_main.domain.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping("/tags")
    public ApiResponse<Tag> getTags() {
        return new SuccessResponse<>(tagService.getTags());
    }

    @PostMapping("/tags")
    public ApiResponse<Tag> createTag(@RequestBody Tag tag) {
        tagService.createTag(tag);
        return new SuccessResponse<>(tag);
    }

    @PatchMapping("/tags/{tag-id}")
    public ApiResponse<Void> updateTag(@PathVariable("tag-id") Long tagId, @RequestBody Tag tag) {
        tagService.updateTag(tagId, tag);
        return new SuccessResponse<>();
    }

    @DeleteMapping("/tags/{tag-id}")
    public ApiResponse<Void> deleteTag(@PathVariable("tag-id") Long tagId) {
        tagService.deleteTag(tagId);
        return new SuccessResponse<>();
    }

}

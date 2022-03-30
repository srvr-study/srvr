package kr.kro.srvrstudy.srvr_common.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.Optional;

@Getter
public abstract class ApiResponse<T> {

    private final BodyHeader header;
    private final BodyContent<T> result;

    ApiResponse(BodyHeader header, BodyContent<T> result) {
        this.header = header;
        this.result = result;
    }

    @RequiredArgsConstructor
    @Getter
    static class BodyHeader {

        private final boolean isSuccessful;
        private final String message;
        private final long code;

    }

    @Getter
    public static class BodyContent<T> {

        @JsonInclude(JsonInclude.Include.NON_DEFAULT)
        private Optional<Integer> totalCount;

        @JsonInclude(JsonInclude.Include.NON_DEFAULT)
        private Optional<T> content;

        @JsonInclude(JsonInclude.Include.NON_DEFAULT)
        private Optional<Collection<T>> contents;

        public BodyContent(T content) {
            this.content = Optional.of(content);
        }

        public BodyContent(Collection<T> contents) {
            this.totalCount = Optional.of(contents.size());
            this.contents = Optional.of(contents);
        }
    }
}

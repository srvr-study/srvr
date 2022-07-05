package kr.kro.srvrstudy.srvr_common.api.response;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import java.util.Collection;

@Getter
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SuccessResponse.class),
        @JsonSubTypes.Type(value = FailureResponse.class)
})
public abstract class ApiResponse<T> {

    private final BodyHeader header;
    private final BodyContent<T> result;

    ApiResponse(BodyHeader header, BodyContent<T> result) {
        this.header = header;
        this.result = result;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BodyHeader {

        private Boolean isSuccessful;
        private String message;
        private long code;
    }

    @Getter
    public static class BodyContent<T> {

        @JsonInclude(JsonInclude.Include.NON_DEFAULT)
        private Integer totalCount;

        @JsonInclude(JsonInclude.Include.NON_DEFAULT)
        private T content;

        @JsonInclude(JsonInclude.Include.NON_DEFAULT)
        private Collection<T> contents;

        public BodyContent(T content) {
            Assert.notNull(content, "content can't be null");

            this.content = content;
        }

        public BodyContent(Collection<T> contents) {
            Assert.notEmpty(contents, "contents can't be empty");

            this.totalCount = contents.size();
            this.contents = contents;
        }
    }
}

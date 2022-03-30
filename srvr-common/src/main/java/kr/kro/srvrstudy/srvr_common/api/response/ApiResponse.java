package kr.kro.srvrstudy.srvr_common.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Optional;

@Setter
@Getter
public abstract class ApiResponse<T> {

    private BodyHeader header;
    private BodyContent<T> content;

    @Setter
    @Getter
    private static class BodyHeader {

        private boolean isSuccessful;
        private String message;
        private long code;

    }

    @Setter
    @Getter
    public static class BodyContent<T> {

        @JsonInclude(JsonInclude.Include.NON_DEFAULT)
        private Optional<Long> totalCount;

        @JsonInclude(JsonInclude.Include.NON_DEFAULT)
        private Optional<T> content;

        @JsonInclude(JsonInclude.Include.NON_DEFAULT)
        private Optional<Collection<T>> contents;

    }
}

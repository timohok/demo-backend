package app;

import io.crnk.core.engine.document.ErrorData;
import io.crnk.core.engine.error.ErrorResponse;
import io.crnk.core.engine.error.ExceptionMapper;

public class ApiExceptionMapper implements ExceptionMapper<JsonApiException> {

    @Override
    public ErrorResponse toErrorResponse(JsonApiException e) {

        ErrorData errorData = ErrorData.builder()
                .setStatus(String.valueOf(e.getStatus()))
                .setDetail(e.getDetail())
                .setTitle(e.getTitle())
                .setCode(e.getCode())
                .build();

        ErrorResponse errorResponse = ErrorResponse.builder()
                .setStatus(e.getStatus())
                .setSingleErrorData(errorData)
                .build();

        return errorResponse;

    }

    @Override
    public JsonApiException fromErrorResponse(ErrorResponse errorResponse) {
        return null;
    }

    @Override
    public boolean accepts(ErrorResponse errorResponse) {
        return false;
    }


}

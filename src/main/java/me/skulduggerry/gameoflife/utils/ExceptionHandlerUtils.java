package me.skulduggerry.gameoflife.utils;

import static me.skulduggerry.gameoflife.utils.DateTimeUtils.currentUtcTimeInMillis;
import static me.skulduggerry.gameoflife.utils.WebRequestUtils.extractPath;
import static org.thymeleaf.util.Validate.notNull;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

public class ExceptionHandlerUtils {

    private ExceptionHandlerUtils() {
    }

    public static ResponseEntity<Map<String, Object>> toResponseEntity(HttpStatus httpStatus, WebRequest webRequest) {
        notNull(httpStatus, "httpStatus");
        notNull(webRequest, "webRequest");
        return handle(httpStatus, webRequest);
    }

    private static final String RESPONSE_ENTITY_BODY_TIMESTAMP = "timestamp";
    private static final String RESPONSE_ENTITY_BODY_STATUS = "status";
    private static final String RESPONSE_ENTITY_BODY_ERROR = "error";
    private static final String RESPONSE_ENTITY_BODY_PATH = "path";

    private static ResponseEntity<Map<String, Object>> handle(HttpStatus httpStatus, WebRequest webRequest) {
        Map<String, Object> body = new HashMap<>();
        body.put(RESPONSE_ENTITY_BODY_TIMESTAMP, currentUtcTimeInMillis());
        body.put(RESPONSE_ENTITY_BODY_STATUS, httpStatus.value());
        body.put(RESPONSE_ENTITY_BODY_ERROR, httpStatus.getReasonPhrase());

        String path = extractPath(webRequest);
        body.put(RESPONSE_ENTITY_BODY_PATH, path);
        return ResponseEntity.status(httpStatus).body(body);
    }
}

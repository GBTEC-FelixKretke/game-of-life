package me.skulduggerry.gameoflife.controller;

import static java.lang.String.format;

import static me.skulduggerry.gameoflife.utils.ExceptionHandlerUtils.toResponseEntity;
import static me.skulduggerry.gameoflife.utils.WebRequestUtils.extractPath;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import lombok.extern.slf4j.Slf4j;
import me.skulduggerry.gameoflife.exceptions.RedirectionFailedException;

@Slf4j
@ControllerAdvice
public class ExceptionHandler {

    private static ResponseEntity<?> handleException(HttpStatus httpStatus, Exception cause, WebRequest webRequest) {
        String path = extractPath(webRequest);
        String request = path != null ? "'" + path + "' " : "";
        log.debug(format("Caught exception while handling request %s therefore status code '%s' [%d] will be returned!", request,
            httpStatus.getReasonPhrase(), httpStatus.value()), cause);
        return toResponseEntity(httpStatus, webRequest);
    }

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @org.springframework.web.bind.annotation.ExceptionHandler({ IOException.class })
    public ResponseEntity<?> internalServerError(Exception cause, WebRequest request) {
        return handleException(INTERNAL_SERVER_ERROR, cause, request);
    }

    @ResponseStatus(NOT_FOUND)
    @org.springframework.web.bind.annotation.ExceptionHandler({ RedirectionFailedException.class })
    public ResponseEntity<?> notFound(Exception cause, WebRequest request) {
        return handleException(NOT_FOUND, cause, request);
    }
}

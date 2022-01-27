package me.skulduggerry.gameoflife.controller;

import static java.lang.String.format;

import static me.skulduggerry.gameoflife.utils.ExceptionHandlerUtils.toResponseEntity;
import static me.skulduggerry.gameoflife.utils.WebRequestUtils.extractPath;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import java.io.IOException;

import com.fasterxml.jackson.databind.exc.ValueInstantiationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import lombok.extern.slf4j.Slf4j;
import me.skulduggerry.gameoflife.exception.InvalidDataException;

@Slf4j
@ControllerAdvice
public class ExceptionHandler {

    private static ResponseEntity<?> handleException(HttpStatus httpStatus, Exception cause, WebRequest webRequest) {
        String path = extractPath(webRequest);
        String request = path != null ? "'" + path + "' " : "";
        log.warn(format("Caught exception while handling request %s therefore status code '%s' [%d] will be returned!", request,
            httpStatus.getReasonPhrase(), httpStatus.value()), cause);
        return toResponseEntity(httpStatus, webRequest);
    }

    @ResponseStatus(code = INTERNAL_SERVER_ERROR)
    @org.springframework.web.bind.annotation.ExceptionHandler({ IOException.class })
    public ResponseEntity<?> internalServerError(Exception cause, WebRequest request) {
        return handleException(INTERNAL_SERVER_ERROR, cause, request);
    }

    @ResponseStatus(code = BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler({ InvalidDataException.class, ValueInstantiationException.class })
    public ResponseEntity<?> badRequest(Exception cause, WebRequest request) {
        return handleException(BAD_REQUEST, cause, request);
    }
}

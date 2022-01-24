package me.skulduggerry.gameoflife.exceptions;

import java.io.IOException;

public class RedirectionFailedException extends IOException {

    public RedirectionFailedException() {
    }

    public RedirectionFailedException(String message) {
        super(message);
    }

    public RedirectionFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public RedirectionFailedException(Throwable cause) {
        super(cause);
    }
}

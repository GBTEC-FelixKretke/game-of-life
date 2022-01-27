package me.skulduggerry.gameoflife.exception;

public class InvalidDataException extends IllegalArgumentException {

    public InvalidDataException(String cause) {
        super("Data is invalid because " + cause);
    }
}

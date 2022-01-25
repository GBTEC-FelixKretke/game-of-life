package me.skulduggerry.gameoflife.exceptions;

public class InvalidDataException extends IllegalArgumentException {

    public InvalidDataException(String cause) {
        super("Data is invalid because " + cause);
    }
}

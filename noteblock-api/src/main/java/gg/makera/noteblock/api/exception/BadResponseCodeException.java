package gg.makera.noteblock.api.exception;

public class BadResponseCodeException extends RuntimeException {

    public BadResponseCodeException(int code, String cause) {
        super("Received bad response code " + code + ". Cause: " + cause);
    }
}

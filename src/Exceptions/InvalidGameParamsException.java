package Exceptions;

public class InvalidGameParamsException extends Exception {
    public InvalidGameParamsException() {
    }

    public InvalidGameParamsException(String message) {
        super(message);
    }

    public InvalidGameParamsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidGameParamsException(Throwable cause) {
        super(cause);
    }

    public InvalidGameParamsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

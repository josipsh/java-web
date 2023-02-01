package hr.algebra.utils.Exceptions;

public class BlobException extends Exception {
    public BlobException() {
    }

    public BlobException(String message) {
        super(message);
    }

    public BlobException(String message, Throwable cause) {
        super(message, cause);
    }

    public BlobException(Throwable cause) {
        super(cause);
    }

    public BlobException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

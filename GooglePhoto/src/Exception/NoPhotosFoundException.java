package Exception;

public class NoPhotosFoundException extends RuntimeException {
    public NoPhotosFoundException(String message) {
        super(message);
    }
}

package Exception;

public class NoPhotosFoundByLocationException extends RuntimeException {
    public NoPhotosFoundByLocationException(String message) {
        super(message);
    }
}

package Exception;

public class NoPhotosFoundByLatLngException extends RuntimeException {
    public NoPhotosFoundByLatLngException(String message) {
        super(message);
    }
}

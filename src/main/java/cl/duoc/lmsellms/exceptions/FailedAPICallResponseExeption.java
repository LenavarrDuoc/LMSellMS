package cl.duoc.lmsellms.exceptions;

public class FailedAPIResponseExeption extends RuntimeException {
    public FailedAPIResponseExeption(String message) {
        super(message);
    }
}

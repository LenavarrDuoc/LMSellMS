package cl.duoc.lmsellms.exceptions;

public class FailedAPICallResponseExeption extends RuntimeException {
    public FailedAPICallResponseExeption(String message) {
        super(message);
    }
}

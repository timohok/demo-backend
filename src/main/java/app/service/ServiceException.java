package app.service;

public class ServiceException extends Exception {

    /**
     * Creates new ServiceException without detail message
     */
    public ServiceException() {
        super();
    }

    /**
     * Constructs an ServiceException with the specified detail message
     *
     * @param message
     */
    public ServiceException(String message) {
        super(message);
    }

    /**
     * Constructs an ServiceException with the specified detail message
     *
     * @param message
     * @param cause
     */
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}

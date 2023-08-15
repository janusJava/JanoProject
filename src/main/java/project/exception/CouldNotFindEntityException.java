package project.exception;

public class CouldNotFindEntityException extends RuntimeException {

    private static final String ENTITY_EXCEPTION = "Could not find entity in DB.";

    public CouldNotFindEntityException(String message) {
        super(message);
    }

}

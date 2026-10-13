package Assessment_HCL.HCL_ASSESSMENT_2_CORE_JAVA_Anshul_Verma_2300321540037.Exceptions;

// Base exception for library-related errors.
public class LibraryException extends RuntimeException {
    public LibraryException(String message) {
        super(message);
    }

    public LibraryException(String message, Throwable cause) {
        super(message, cause);
    }
}
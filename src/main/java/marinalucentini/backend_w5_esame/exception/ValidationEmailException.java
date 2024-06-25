package marinalucentini.backend_w5_esame.exception;

public class ValidationEmailException extends RuntimeException{
    public ValidationEmailException (String email){
        super("L'email non è valida assicurati di digitare il formato corretto: esempio@gmail.com");
    }
    public static void validateEmail(String email){
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!email.matches(emailRegex)) {
            throw new ValidationEmailException(email);
        }
    }
}

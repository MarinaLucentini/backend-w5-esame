package marinalucentini.backend_w5_esame.exception;

public class InvalidCityException extends RuntimeException{
    public InvalidCityException (String string){
        super("La città " + string + "non è valida, riprova");
    }
}

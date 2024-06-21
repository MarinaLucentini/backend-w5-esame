package marinalucentini.backend_w5_esame.exception;

public class ElementNotFound extends RuntimeException{
    public ElementNotFound(String id){
        super("L'elemento cercato con id: " + id + "non è stato trovato");
    }
}

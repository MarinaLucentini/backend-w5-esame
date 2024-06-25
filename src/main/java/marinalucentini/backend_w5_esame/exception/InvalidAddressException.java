package marinalucentini.backend_w5_esame.exception;

public class InvalidAddressException extends RuntimeException{
    public InvalidAddressException(String address){
        super("L'idirizzo scritto " + address + "non è valido");
    }
}

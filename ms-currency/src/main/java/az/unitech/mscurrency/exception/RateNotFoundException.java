package az.unitech.mscurrency.exception;

public class RateNotFoundException extends RuntimeException{
    public RateNotFoundException(String message){
        super(message);
    }
}

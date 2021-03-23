package by.epamtc.web_app.service.exception;

public class IncorrectDataException extends Exception{
    public IncorrectDataException(){
        super();
    }

    public IncorrectDataException (String message){
        super(message);
    }

    public IncorrectDataException (Exception e){
        super(e);
    }

    public IncorrectDataException (String message, Exception e){
        super(message);
    }
}

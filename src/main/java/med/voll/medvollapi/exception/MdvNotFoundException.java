package med.voll.medvollapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MdvNotFoundException extends RuntimeException{
    public MdvNotFoundException() {
        super("Resource not found!");
    }
    public MdvNotFoundException(String exception) {
        super(exception);
    }
}

package encurtador.urlshortner.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApplicationException extends  RuntimeException{
    public ApplicationException(String message) {
        super(message);
    }
}

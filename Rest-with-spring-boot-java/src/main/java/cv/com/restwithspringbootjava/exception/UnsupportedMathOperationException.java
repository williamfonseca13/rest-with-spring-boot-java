package cv.com.restwithspringbootjava.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;
import java.io.Serializable;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException extends RuntimeException implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public UnsupportedMathOperationException(String message) {
        super(message);
    }
}

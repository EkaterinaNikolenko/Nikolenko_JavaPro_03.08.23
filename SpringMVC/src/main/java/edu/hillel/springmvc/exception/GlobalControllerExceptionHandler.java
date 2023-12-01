package edu.hillel.springmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class GlobalControllerExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorBody> handleConflict(Exception e) throws IOException {
        System.out.println("We have a problem!" + e.getMessage());
        e.printStackTrace();
        return new ResponseEntity<>(new ErrorBody("common_error", "server is unavailable "), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    static class ErrorBody {
        private String errorName;
        private String errorDetails;

        public ErrorBody(String errorName, String errorDetails) {
            this.errorName = errorName;
            this.errorDetails = errorDetails;
        }

        public String getErrorName() {
            return errorName;
        }

        public String getErrorDetails() {
            return errorDetails;
        }
    }
}

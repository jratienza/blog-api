package xyz.mynt.blogapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class NoSuchElementExceptionHandler {
    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<Map<String, String>> handleNoSuchElementException(NoSuchElementException e){
        Map<String, String> response = new HashMap<>();
        response.put("message", "Blog ID not found.");
        return  ResponseEntity.ok().body(response);
    }
}
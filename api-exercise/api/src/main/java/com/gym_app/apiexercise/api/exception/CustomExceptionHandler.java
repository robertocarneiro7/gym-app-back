package com.gym_app.apiexercise.api.exception;

import com.gym_app.apiexercise.domain.shared.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    private ResponseEntity<Map<String, Object>> exceptions(BusinessException exception) {
        this.logger.error(exception.getMessage(), exception);
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("message", exception.getMessage());
        return new ResponseEntity<>(attributes, HttpStatus.BAD_REQUEST);
    }
}

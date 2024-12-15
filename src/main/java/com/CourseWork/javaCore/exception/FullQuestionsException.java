package com.CourseWork.javaCore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (code = HttpStatus.BAD_REQUEST)
public class FullQuestionsException extends RuntimeException {
    public FullQuestionsException(String message) {
        super(message);
    }
}

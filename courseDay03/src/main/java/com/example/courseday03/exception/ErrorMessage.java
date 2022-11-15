package com.example.courseday03.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.net.http.HttpRequest;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorMessage {
    private HttpStatus status;
    private Object message;
}

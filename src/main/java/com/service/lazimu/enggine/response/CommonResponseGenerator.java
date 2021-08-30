package com.service.lazimu.enggine.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
public class CommonResponseGenerator {
    @ResponseStatus(value=HttpStatus.OK)
    public <T> ResponseEntity<CommonResponse<T>> successResponse(Object content) {
        CommonResponse commonResponse = new CommonResponse<>();
        commonResponse.setStatus("200");
        commonResponse.setMessage("SUCCESS");
        commonResponse.setContent(content);
        return new ResponseEntity<CommonResponse<T>>(commonResponse, HttpStatus.OK);
    }

    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
    public <T> ResponseEntity<CommonResponse<T>> failResponse(String content) {
        CommonResponse commonResponse = new CommonResponse<>();
        commonResponse.setStatus("500");
        commonResponse.setMessage("ERROR");
        commonResponse.setContent(content);
        return new ResponseEntity<CommonResponse<T>>(commonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

package ru.test.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import ru.test.task.model.ErrorResponse;
import ru.test.task.model.ResponsesDTO;
import ru.test.task.service.TestTaskService;

@RestController
@RequestMapping(value = "/test/task")
public class Controller {

    @Autowired
    private TestTaskService testTaskService;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAnswers(
                                @RequestParam(value = "intitle", required = true) String intitle) {

        ResponsesDTO responsesDTO = null;

        try {
            responsesDTO = testTaskService.getAnswers(intitle);
            return new ResponseEntity<ResponsesDTO>(responsesDTO, HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<ErrorResponse>(new ErrorResponse(e.getStatusCode().toString(), e.getMessage()), HttpStatus.BAD_REQUEST);
        }



    }



}



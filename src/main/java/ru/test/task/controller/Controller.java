package ru.test.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.test.task.model.ResponsesDTO;
import ru.test.task.service.TestTaskService;

@RestController
@RequestMapping(value = "/test/task")
public class Controller {

    @Autowired
    private TestTaskService testTaskService;


    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody ResponsesDTO getAnswers(
                                @RequestParam(value = "intitle", required = true) String intitle) {
        ResponsesDTO responsesDTO = testTaskService.getAnswers(intitle);

        return responsesDTO;

    }



}



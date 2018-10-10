package ru.test.task.service;

import ru.test.task.model.AnswersDTO;
import ru.test.task.model.ResponsesDTO;

public interface TestTaskService {
    ResponsesDTO getAnswers(String intitle);
}

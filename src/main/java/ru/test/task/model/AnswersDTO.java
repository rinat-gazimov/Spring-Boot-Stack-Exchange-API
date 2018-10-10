package ru.test.task.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class AnswersDTO {

    private List<AnswerDTO> items;

    public AnswersDTO() {
    }

    public AnswersDTO(List<AnswerDTO> items) {
        this.items = items;
    }
}

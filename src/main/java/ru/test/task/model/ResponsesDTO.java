package ru.test.task.model;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponsesDTO {

    private List<ResponseDTO> responses;

    public ResponsesDTO(List<ResponseDTO> responses) {
        this.responses = responses;
    }
}

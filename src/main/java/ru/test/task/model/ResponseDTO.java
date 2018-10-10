package ru.test.task.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ResponseDTO {

    @JsonSerialize(using = JsonDateSerializer.class, include=JsonSerialize.Inclusion.ALWAYS)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date queryDate;
    private String title;
    private String userLink;
    private Boolean answered;


    public ResponseDTO(Date queryDate, String title, String userLink) {
        this.queryDate = queryDate;
        this.title = title;
        this.userLink = userLink;
    }

    public ResponseDTO(AnswerDTO answerDTO) {

        this.queryDate = new Date(Long.valueOf(answerDTO.getCreation_date()));
        this.title = answerDTO.getTitle();
        this.userLink = answerDTO.getOwner().getLink();
        this.answered = Boolean.valueOf(answerDTO.getIs_answered());

    }


}

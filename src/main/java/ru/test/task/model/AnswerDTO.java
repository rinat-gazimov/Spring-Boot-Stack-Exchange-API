package ru.test.task.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AnswerDTO {

    private List<String> tags;
    private Owner owner;
    private String is_answered;
    private String view_count;
    private String answer_count;
    private String score;
    private String last_activity_date;
    private String creation_date;
    private String last_edit_date;
    private String question_id;
    private String link;
    private String title;

    public AnswerDTO() {
    }

    public AnswerDTO(List<String> tags, Owner owner, String is_answered, String view_count, String answer_count, String score, String last_activity_date, String creation_date, String last_edit_date, String question_id, String link, String title) {
        this.tags = tags;
        this.owner = owner;
        this.is_answered = is_answered;
        this.view_count = view_count;
        this.answer_count = answer_count;
        this.score = score;
        this.last_activity_date = last_activity_date;
        this.creation_date = creation_date;
        this.last_edit_date = last_edit_date;
        this.question_id = question_id;
        this.link = link;
        this.title = title;
    }
}


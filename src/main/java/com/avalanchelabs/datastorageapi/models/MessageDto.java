package com.avalanchelabs.datastorageapi.models;

import com.avalanchelabs.datastorageapi.exceptions.SinceDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

public class MessageDto {

    @Min(value=1)
    private int foreignId;

    @NotBlank
    @Pattern(regexp = "[a-zA-Z0-9]*", message="{word.invalid}")
    private String word;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @SinceDate(date = "2015-01-01")
    private LocalDateTime created;

    public int getForeignId() {
        return foreignId;
    }

    public String getWord() {
        return word;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setForeignId(int foreignId) {
        this.foreignId = foreignId;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}

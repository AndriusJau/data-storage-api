package com.avalanchelabs.datastorageapi.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class MessageModel {

    private int foreignId;
    private String word;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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

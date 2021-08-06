package com.avalanchelabs.datastorageapi.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private int foreignId;
    private String word;
    private LocalDateTime created;

    public Message() {
    }

    public Message(int foreignId, String word, LocalDateTime created) {
        this.foreignId = foreignId;
        this.word = word;
        this.created = created;
    }

    public int getForeignId() {
        return foreignId;
    }

    public void setForeignId(int foreignId) {
        this.foreignId = foreignId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}

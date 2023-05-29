package org.example.oneToMany.model;

import javax.persistence.*;

@Entity
@Table(name = "answers")

public class Answer {
    public Answer() {
    }

    public Answer(String answer, boolean corectFlag) {
        this.answer = answer;
        this.corectFlag = corectFlag;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String answer;
    private boolean corectFlag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorectFlag() {
        return corectFlag;
    }

    public void setCorectFlag(boolean corectFlag) {
        this.corectFlag = corectFlag;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
                ", corectFlag=" + corectFlag +
                '}';
    }
}

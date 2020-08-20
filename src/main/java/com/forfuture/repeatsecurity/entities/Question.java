package com.forfuture.repeatsecurity.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "question_table")
@Getter
@Setter
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Lob
    @Column(name = "question", nullable = false)
    private String question;

    @ManyToOne
    @JoinColumn(name = "word", nullable = false)
    private Word answer;


    public Question(String question, Word answer) {
        this.question = question;
        this.answer = answer;
    }

}

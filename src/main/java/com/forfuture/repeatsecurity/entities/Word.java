package com.forfuture.repeatsecurity.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "word")
@Getter
@Setter
@ToString
public class Word {

    @Id
    private String word;

    @Lob
    @Column(name="definition", nullable = false)
    private String definition;

    @Lob
    @Column(name = "example")
    private String example;

    @OneToMany(mappedBy = "answer")
    private List<Question> questions;

    public Word() {}

    public Word(String word, String definition, String example) {
        this.word = word;
        this.definition = definition;
        this.example = example;
    }
}

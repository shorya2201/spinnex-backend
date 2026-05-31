// src/main/java/com/kaal/spinnex/model/entity/Question.java
package com.kaal.spinnex.model.entity;

import com.kaal.spinnex.model.enums.Category;
import com.kaal.spinnex.model.enums.QuestionType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "questions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Compatible with PostgreSQL serial/identity columns
    private Long id;

    @Column(nullable = false, length = 500)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private QuestionType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;
}
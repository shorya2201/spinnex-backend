// src/main/java/com/kaal/spinnex/service/QuestionService.java
package com.kaal.spinnex.service;

import com.kaal.spinnex.model.entity.Question;
import com.kaal.spinnex.model.enums.Category;
import com.kaal.spinnex.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Question> getQuestionsByCategoryShuffled(String categoryStr) {
        try {
            Category category = Category.valueOf(categoryStr.toUpperCase());
            List<Question> questions = questionRepository.findByCategory(category);

            // Randomly orders questions before shipping them over HTTP to the Flutter app
            Collections.shuffle(questions);
            return questions;
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid category provided: " + categoryStr);
        }
    }
}
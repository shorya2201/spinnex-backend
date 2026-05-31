// src/main/java/com/kaal/spinnex/controller/QuestionController.java
package com.kaal.spinnex.controller;

import com.kaal.spinnex.model.entity.Question;
import com.kaal.spinnex.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping
    public ResponseEntity<?> getQuestions(@RequestParam String category) {
        try {
            List<Question> questions = questionService.getQuestionsByCategoryShuffled(category);
            if (questions.isEmpty()) {
                return ResponseEntity.status(404).body("No questions found for category: " + category);
            }
            return ResponseEntity.ok(questions);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
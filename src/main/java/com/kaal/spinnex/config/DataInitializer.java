// src/main/java/com/kaal/spinnex/config/DataInitializer.java
package com.kaal.spinnex.config;

import com.kaal.spinnex.model.entity.Question;
import com.kaal.spinnex.model.enums.Category;
import com.kaal.spinnex.model.enums.QuestionType;
import com.kaal.spinnex.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final QuestionRepository repository;

    @Override
    public void run(String... args) {
        if (repository.count() == 0) {
            repository.saveAll(Arrays.asList(
                    // CLASSIC CATEGORY
                    new Question(null, "What is the most childish thing you still do?", QuestionType.TRUTH,
                            Category.CLASSIC),
                    new Question(null, "Have you ever let someone take the blame for something you did?",
                            QuestionType.TRUTH, Category.CLASSIC),
                    new Question(null, "Do your best impression of a chicken until your next turn.", QuestionType.DARE,
                            Category.CLASSIC),
                    new Question(null, "Let the person to your right draw a mustache on you with a washable marker.",
                            QuestionType.DARE, Category.CLASSIC),
                    new Question(null, "What is your absolute biggest pet peeve?", QuestionType.TRUTH,
                            Category.CLASSIC),

                    // PARTY CATEGORY
                    new Question(null, "What is the worst advice you have ever given someone?", QuestionType.TRUTH,
                            Category.PARTY),
                    new Question(null, "Perform a dramatic 30-second fitness infomercial right now.", QuestionType.DARE,
                            Category.PARTY),
                    new Question(null, "If you could trade lives with anyone in this room for a day, who would it be?",
                            QuestionType.TRUTH, Category.PARTY),
                    new Question(null,
                            "Let the group compose a text message and send it to any random contact on your phone.",
                            QuestionType.DARE, Category.PARTY),
                    new Question(null, "What is the funniest song you know all the lyrics to?", QuestionType.TRUTH,
                            Category.PARTY),

                    // SPICY CATEGORY
                    new Question(null, "What is a secret romantic fantasy you've never told anyone?",
                            QuestionType.TRUTH, Category.SPICY),
                    new Question(null,
                            "Stare deeply into the eyes of the person opposite you for 30 seconds without laughing.",
                            QuestionType.DARE, Category.SPICY),
                    new Question(null, "Who in this room do you think would be the best kisser?", QuestionType.TRUTH,
                            Category.SPICY),
                    new Question(null, "Give a 1-minute back massage to the player sitting on your left.",
                            QuestionType.DARE, Category.SPICY),
                    new Question(null, "What is the most adventurous place you have ever kissed someone?",
                            QuestionType.TRUTH, Category.SPICY)));
            System.out.println(">> PostgreSQL database populated with dynamic game content successfully.");
        }
    }
}
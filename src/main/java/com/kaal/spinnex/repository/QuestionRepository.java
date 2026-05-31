// src/main/java/com/kaal/spinnex/repository/QuestionRepository.java
package com.kaal.spinnex.repository;

import com.kaal.spinnex.model.entity.Question;
import com.kaal.spinnex.model.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByCategory(Category category);
}
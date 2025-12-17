package com.certprep.certprep.common.exception;

import com.certprep.certprep.category.entity.Category;
import com.certprep.certprep.category.repository.CategoryRepository;
import com.certprep.certprep.question.entity.Question;
import com.certprep.certprep.question.repository.QuestionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder {
    @Bean
    CommandLineRunner seedData(CategoryRepository categoryRepository, QuestionRepository questionRepository) {
        return args -> {
            if(categoryRepository.count() == 0) {
                // seed category
                Category java = new Category();
                java.setName("Java");
                java.setStatus((byte) 1);
                categoryRepository.save(java);

                // save question
                Question question = new Question();
                question.setCategory(java);
                question.setQuestion("This is a question");
                question.setExplanation("This is a explanation");
                questionRepository.save(question);
            }
        };
    }
}

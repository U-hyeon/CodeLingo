package SideProject.CodeLingo.repository;

import SideProject.CodeLingo.domain.Quiz;

import java.util.List;
import java.util.Optional;

public interface QuizRepository {
    Quiz save(Quiz quiz);
    Optional<Quiz> findByQuizId(Long quizId);
    Optional<Quiz> findByLanguage(String language);
    Optional<Quiz> findByLevel(String level);
    List<Quiz> findAll();
}

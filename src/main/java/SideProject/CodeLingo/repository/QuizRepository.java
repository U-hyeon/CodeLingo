package SideProject.CodeLingo.repository;

import SideProject.CodeLingo.domain.Quiz;

import java.util.List;
import java.util.Optional;

public interface QuizRepository {
    Quiz save(Quiz quiz);
    Optional<Quiz> findByQuizId(Long quizId);
    Optional<List<Quiz>> findByLanguage(String language);
    Optional<List<Quiz>> findByLevel(Long level);
    List<Quiz> findAll();
}

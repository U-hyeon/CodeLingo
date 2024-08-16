package SideProject.CodeLingo.repository;

import SideProject.CodeLingo.domain.Quiz;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryQuizRepository implements QuizRepository {

    private static Map<Long, Quiz> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Quiz save(Quiz quiz) {
        quiz.setQuizId(++sequence);
        store.put(quiz.getQuizId(), quiz);
        return quiz;
    }

    @Override
    public Optional<Quiz> findByQuizId(Long quizId) {
        return Optional.ofNullable(store.get(quizId));
    }

    @Override
    public Optional<Quiz> findByLanguage(String language) {
        return Optional.empty();
    }

    @Override
    public Optional<Quiz> findByLevel(String level) {
        return Optional.empty();
    }


    @Override
    public List<Quiz> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
    
}

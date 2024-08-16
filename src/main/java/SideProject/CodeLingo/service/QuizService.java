package SideProject.CodeLingo.service;

import SideProject.CodeLingo.domain.Quiz;

import SideProject.CodeLingo.domain.QuizBlockRelocation;
import SideProject.CodeLingo.domain.QuizSingle;
import SideProject.CodeLingo.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

    private final QuizRepository quizRepository;

    @Autowired
    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Long createQuiz(Quiz quiz) {
        quizRepository.save(quiz);
        return quiz.getQuizId();
    }
    public Quiz findOneByQuizId(Long quizId) {
        return quizRepository.findByQuizId(quizId).orElse(null);
    }

    /**
     * quizSingle
     */
    public void printQuiz(QuizSingle quiz) {

    }
    public void submitAnswer(QuizSingle quiz) {

    }

    /**
     * quizBlockRelocation
     */
    public void printQuiz(QuizBlockRelocation quiz){

    }
    public void submitAnswer(QuizBlockRelocation quiz) {

    }

}

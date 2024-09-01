package SideProject.CodeLingo.service;

import SideProject.CodeLingo.domain.Quiz;

import SideProject.CodeLingo.domain.Quiz_BlockRelocation;
import SideProject.CodeLingo.domain.Quiz_Single;
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
    public void printQuiz(Quiz_Single quiz) {

    }
    public void submitAnswer(Quiz_Single quiz) {

    }

    /**
     * quizBlockRelocation
     */
    public void printQuiz(Quiz_BlockRelocation quiz){

    }
    public void submitAnswer(Quiz_BlockRelocation quiz) {

    }

}

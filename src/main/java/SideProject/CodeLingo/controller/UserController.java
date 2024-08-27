package SideProject.CodeLingo.controller;

import SideProject.CodeLingo.controller.QuizController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class UserController {
    private final QuizController quizController;

    @Autowired
    public UserController (QuizController quizController) {
        this.quizController = quizController;
    }

    // private final Map<quizController.quizService.quizRepository, Long>;
}

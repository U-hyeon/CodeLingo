package SideProject.CodeLingo.controller;

import SideProject.CodeLingo.domain.Quiz;
import SideProject.CodeLingo.service.QuizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("create-test-quiz")
    public String testQuiz(Model model) {
        Quiz testQuiz = new Quiz();
        List<String> testExp = List.of("a","b","c","d");

        testQuiz.setQuizCategory("java");
        testQuiz.setQuizLevel(3L);
        testQuiz.setScript("테스트 문제입니다.");
        testQuiz.setExamples(testExp);

        quizService.createQuiz(testQuiz);

        return "Test quiz created!";
    }


    @GetMapping("print-quiz-by-id")
    @ResponseBody
    public String printQuizById (@RequestParam ("quizId") Long quizId) {
        String printFormat;

        Quiz testQuiz = new Quiz();
        List<String> testExp = List.of("a","b","c","d");

        testQuiz.setQuizCategory("java");
        testQuiz.setQuizLevel(3L);
        testQuiz.setScript("테스트 문제입니다.");
        testQuiz.setExamples(testExp);

        quizService.createQuiz(testQuiz);

        Quiz quiz = quizService.findOneByQuizId(quizId);

        printFormat = (quiz.getQuizId() +"번 문제" + System.lineSeparator()
                + "Q. " + quiz.getScript() + System.lineSeparator()
                + "보기:" + quiz.getExamples());

        return printFormat;
    }
}

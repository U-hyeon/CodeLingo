package SideProject.CodeLingo.controller;

import SideProject.CodeLingo.domain.Quiz;
import SideProject.CodeLingo.mapper.QuizMapper;
import SideProject.CodeLingo.service.QuizService;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuizController {
    private QuizMapper quizMapper;
/** GET */
/** GET QUIZ INFO */
    @GetMapping("/quizzes")
    public Quiz getQuizInfo(@RequestParam("quizId") Long quizId) {
        Quiz quiz = quizMapper.getOneQuiz(quizId);
        return  quiz;
    }
    @GetMapping("/quizzes/all")
    public List<Quiz> getAllQuiz() {
        return quizMapper.getAllQuiz();
    }
    @GetMapping("/quizzes/all/categories")
    public List<Quiz> getAllQuiz_category(@RequestParam("quizCategory") String quizCategory) {
        return quizMapper.getAllQuiz_category(quizCategory);
    }
    @GetMapping("/quizzes/all/categories-levels")
    public List<Quiz> getAllQuiz_level(
            @RequestParam("quizCategory") String quizCategory,
            @RequestParam("quizLevel") Long quizLevel
    ) {
        return quizMapper.getAllQuiz_level(quizCategory, quizLevel);
    }
/** GET QUIZ DATA */
    @GetMapping("/quizzes/categories")
    public List<String> getAllCategory() {
        return quizMapper.getAllCategory();
    }
    @GetMapping("/quizzes/categories/levels")
    public List<Long> getAllLevel_category(@RequestParam("quizCategory") String quizCategory) {
        return quizMapper.getAllLevel_category(quizCategory);
    }

/** PUT */
    @PutMapping("/quizzes")
    public void putNewQuiz(
            @RequestParam("quizId") Long quizId,
            @RequestParam("quizCategory") String quizCategory,
            @RequestParam("quizLevel") Long quizLevel,
            @RequestParam("quizScript") String quizScript,
            @RequestParam("quizImgUrl") String quizImgUrl,
            @RequestParam("quizExamples") List<String> quizExamples
    ) {
        quizMapper.insertQuiz(quizId, quizCategory, quizLevel, quizScript, quizImgUrl, quizExamples);
    }
/** POST */
    @PostMapping("/quizzes")
    public void postQuiz(
            @RequestParam("quizId") Long quizId,
            @RequestParam("quizCategory") String quizCategory,
            @RequestParam("quizLevel") Long quizLevel,
            @RequestParam("quizScript") String quizScript,
            @RequestParam("quizImgUrl") String quizImgUrl,
            @RequestParam("quizExamples") List<String> quizExamples
    ) {
        quizMapper.updateQuiz(quizId, quizCategory, quizLevel, quizScript, quizImgUrl, quizExamples);
    }
/** DELETE */
    @DeleteMapping("/quizzes")
    public void deleteQuiz(@RequestParam("quizId") Long quizId) {
        quizMapper.deleteOneQuiz(quizId);
    }
}

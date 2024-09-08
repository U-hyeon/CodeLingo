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

    @GetMapping("/quiz/{quizId}")
    public Quiz getQuizInfo(@PathVariable("quizId") Long quizId) {
        Quiz quiz = quizMapper.getOneQuiz(quizId);
        return  quiz;
    }

    @PutMapping("/quiz/{quizId}")
    public void putNewQuiz(
            @PathVariable("quizId") Long quizId,
            @RequestParam("quizCategory") String quizCategory,
            @RequestParam("quizLevel") Long quizLevel,
            @RequestParam("quizScript") String quizScript,
            @RequestParam("quizImgUrl") String quizImgUrl,
            @RequestParam("quizExamples") List<String> quizExamples
            ) {
        quizMapper.insertQuiz(quizId, quizCategory, quizLevel, quizScript, quizImgUrl, quizExamples);
    }

    @PostMapping("/quiz/{quizId}")
    public void postQuiz(
            @PathVariable("quizId") Long quizId,
            @RequestParam("quizCategory") String quizCategory,
            @RequestParam("quizLevel") Long quizLevel,
            @RequestParam("quizScript") String quizScript,
            @RequestParam("quizImgUrl") String quizImgUrl,
            @RequestParam("quizExamples") List<String> quizExamples
    ) {
        quizMapper.updateQuiz(quizId, quizCategory, quizLevel, quizScript, quizImgUrl, quizExamples);
    }

    @DeleteMapping("/quiz/{quizId}")
    public void deleteQuiz(@PathVariable("quizId") Long quizId) {
        quizMapper.deleteOneQuiz(quizId);
    }
}

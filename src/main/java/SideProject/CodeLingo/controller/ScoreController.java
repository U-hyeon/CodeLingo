package SideProject.CodeLingo.controller;

import SideProject.CodeLingo.domain.Score;
import SideProject.CodeLingo.mapper.ScoreMapper;
import SideProject.CodeLingo.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ScoreController {
    private final ScoreService scoreService;

    @Autowired
    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }


    private ScoreMapper mapper;


    @GetMapping("/score")
    public Long getScoreOne(
            @RequestParam("userId") Long userId,
            @RequestParam("quizId") Long quizId
    ) {
        return mapper.getQuizScore(userId, quizId);
    }

    @GetMapping("/score/user/{userId}")
    public List<Score> getAllScoreOfUser (
            @PathVariable("userId") Long userId
    ) {
        return mapper.getAllScores_ofUser(userId);
    }

    @GetMapping("/score/quiz/{quizId}")
    public List<Score> getAllScoreOfQuiz (
            @PathVariable("quizId") Long quizId
    ) {
        return mapper.getAllScores_ofQuiz(quizId);
    }

    @GetMapping("/score")
    public List<Score> getAllScoreOfUser(
            @RequestParam("userId") Long userId,
            @RequestParam("quizCategory") String quizCategory,
            @RequestParam("quizLevel") Long quizLevel
    ) {
        return mapper.getAllScores_ofUser(userId);
    }

    @PutMapping("/score/{scoreId}")
    public void putScore(
            @PathVariable("scoreId") Long scoreId,
            @RequestParam("userId") Long userId,
            @RequestParam("quizId") Long quizId,
            @RequestParam("quizScore") Long quizScore
            ) {
        mapper.insertQuizScore(scoreId, userId, quizId, quizScore);
    }

    @PostMapping("/score")
    public void postScore(
            @RequestParam("userId") Long userId,
            @RequestParam("quizId") Long quizId,
            @RequestParam("quizScore") Long quizScore
            ) {
        mapper.updateQuizScore(userId, quizId, quizScore);
    }
}

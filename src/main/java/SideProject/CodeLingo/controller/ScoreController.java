package SideProject.CodeLingo.controller;

import SideProject.CodeLingo.domain.Score;
import SideProject.CodeLingo.mapper.ScoreMapper;
import SideProject.CodeLingo.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ScoreController {
    private final ScoreService scoreService;

    @Autowired
    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }


    private ScoreMapper mapper;

    @PutMapping("/score/{scoreId}")
    public void putScore(
            @PathVariable("scoreId") Long scoreId,
            @RequestParam("userId") Long userId,
            @RequestParam("quizId") Long quizId,
            @RequestParam("quizScore") Long quizScore
            ) {
        mapper.insertScore(scoreId, userId, quizId, quizScore);
    }

    @PostMapping("/score/{scoreId}")
    public void postScore(
            @PathVariable("scoreId") Long scoreId,
            @RequestParam("userId") Long userId,
            @RequestParam("quizId") Long quizId,
            @RequestParam("quizScore") Long quizScore
            ) {
        mapper.updateScore(scoreId, userId, quizId, quizScore);
    }


    @GetMapping("/score")
    public Score getScoreOne(
            @RequestParam("userId") Long userId,
            @RequestParam("quizId") Long quizId
            ) {
        return mapper.getScoreOne(userId, quizId);
    }

    @GetMapping("/score/user/{userId}")
    public Optional<List<Score>> getAllScoreOfUser (
            @PathVariable("userId") Long userId
            ) {
        return mapper.getAllScoreOfUser(userId);
    }

    @GetMapping("/score/quiz/{quizId}")
    public Optional<List<Score>> getAllScoreOfQuiz (
            @PathVariable("quizId") Long quizId
            ) {
        return mapper.getAllScoreOfQuiz(quizId);
    }

    @GetMapping("/score")
    public Optional<List<Score>> getUserScoreInLevel(
            @RequestParam("userId") Long userId,
            @RequestParam("quizCategory") String quizCategory,
            @RequestParam("quizLevel") Long quizLevel
            ) {
        return mapper.getUserScoreInLevel(userId, quizCategory, quizLevel);
    }

}

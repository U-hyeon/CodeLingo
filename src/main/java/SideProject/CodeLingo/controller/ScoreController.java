package SideProject.CodeLingo.controller;

import SideProject.CodeLingo.domain.Score;
import SideProject.CodeLingo.mapper.ScoreMapper;
import SideProject.CodeLingo.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScoreController {
    private ScoreMapper scoreMapper;
/** GET */
    @GetMapping("/scores")
    public Long getScoreOne(
            @RequestParam("userId") Long userId,
            @RequestParam("quizId") Long quizId
    ) {
        return scoreMapper.getQuizScore(userId, quizId);
    }
    @GetMapping("/scores/all/users")
    public List<Score> getAllScoreOfUser(
            @RequestParam("userId") Long userId,
            @RequestParam("quizCategory") String quizCategory,
            @RequestParam("quizLevel") Long quizLevel
    ) {
        return scoreMapper.getAllScores_user(userId);
    }
    @GetMapping("/scores/all/quizzes")
    public List<Score> getAllScoreOfQuiz (
            @RequestParam("quizId") Long quizId
    ) {
        return scoreMapper.getAllScores_quiz(quizId);
    }
/** PUT */
    @PutMapping("/scores")
    public void putScore(
            @RequestParam("scoreId") Long scoreId,
            @RequestParam("userId") Long userId,
            @RequestParam("quizId") Long quizId,
            @RequestParam("quizScore") Long quizScore
            ) {
        scoreMapper.insertQuizScore(scoreId, userId, quizId, quizScore);
    }
/** POST */
    @PostMapping("/scores")
    public void postScore(
            @RequestParam("userId") Long userId,
            @RequestParam("quizId") Long quizId,
            @RequestParam("quizScore") Long quizScore
            ) {
        scoreMapper.updateQuizScore(userId, quizId, quizScore);
    }
/** DELETE */
    @DeleteMapping("/scores/users")
    public void deleteALLScore_user(@RequestParam("userId") Long userId) {
        scoreMapper.deleteAllScores_user(userId);
    }
    @DeleteMapping("/scores/quizzes")
    public void deleteAllScore_quiz(@RequestParam("quizId") Long quizId) {
        scoreMapper.deleteAllScores_quiz(quizId);
    }
}

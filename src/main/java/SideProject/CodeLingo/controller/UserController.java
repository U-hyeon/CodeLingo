package SideProject.CodeLingo.controller;

import SideProject.CodeLingo.controller.QuizController;
import SideProject.CodeLingo.domain.User;
import SideProject.CodeLingo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {
    private final QuizController quizController;

    @Autowired
    public UserController (QuizController quizController) {
        this.quizController = quizController;
    }

    private UserMapper mapper;

    // private final Map<quizController.quizService.quizRepository, Long>;

    @PutMapping("/user/{userId}")
    public void putUserProfile(@PathVariable("userId") Long userId, @RequestParam("userName") String userName, @RequestParam("userEmail") String userEmail) {
        mapper.insertUserProfile(userId, userName, userEmail);
    }

    @GetMapping("/user/{userId}")
    public User GetUserProfile(@PathVariable("userId") Long userId) {
        return mapper.getUserProfile(userId);
    }

    @PostMapping("/user/{userId}")
    public void PostUserProfile(@PathVariable("userId") Long userId, @RequestParam("userName") String userName, @RequestParam("userEmail") String userEmail) {
        mapper.updateUserProfile(userId, userName, userEmail);
    }

    @DeleteMapping("/user/{userId}")
    public void PostUserProfile(@PathVariable("userId") Long userId) {
        mapper.deleteUserProfile(userId);
    }

}

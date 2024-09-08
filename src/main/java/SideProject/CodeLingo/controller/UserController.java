package SideProject.CodeLingo.controller;

import SideProject.CodeLingo.domain.User;
import SideProject.CodeLingo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserMapper userMapper;

    // private final Map<quizController.quizService.quizRepository, Long>;
/** GET */
    @GetMapping("/users")
    public User getUserProfile(@RequestParam("userId") Long userId) {
        return userMapper.getUserProfile(userId);
    }
    @GetMapping("/users/all")
    public List<User> getAllUserProfile() {
        return userMapper.getAllUserProfile();
    }
/** PUT */
    @PutMapping("/users")
    public void putUserProfile(@RequestParam("userId") Long userId, @RequestParam("userName") String userName, @RequestParam("userEmail") String userEmail) {
        userMapper.insertUserProfile(userId, userName, userEmail);
    }
/** POST */
    @PostMapping("/users")
    public void postUserProfile(@RequestParam("userId") Long userId, @RequestParam("userName") String userName, @RequestParam("userEmail") String userEmail) {
        userMapper.updateUserProfile(userId, userName, userEmail);
    }
/** DELETE */
    @DeleteMapping("/users")
    public void postUserProfile(@RequestParam("userId") Long userId) {
        userMapper.deleteUserProfile(userId);
    }

}

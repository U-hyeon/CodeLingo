package SideProject.CodeLingo.domain;

import SideProject.CodeLingo.repository.QuizRepository;

import java.util.List;
import java.util.Map;

public class User {

    public Long userId;
    public String userName;
    public String userEmail;
    /**
     * quizScore
     * < [java, spring, python, ], < [0,1,2,... (quizLevel) ], score> >
     */
    public Map<QuizRepository, Long> userQuizScore;

    public Map<QuizRepository, Long> getUserQuizScore() {
        return userQuizScore;
    }

    public void setUserQuizScore(Map<QuizRepository, Long> userQuizScore) {
        this.userQuizScore = userQuizScore;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}

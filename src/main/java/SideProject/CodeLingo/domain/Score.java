package SideProject.CodeLingo.domain;

public class Score {
    public Long userId;
    public Long quizId;
    public Long quizScore;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public Long getQuizScore() {
        return quizScore;
    }

    public void setQuizScore(Long score) {
        this.quizScore = quizScore;
    }
}

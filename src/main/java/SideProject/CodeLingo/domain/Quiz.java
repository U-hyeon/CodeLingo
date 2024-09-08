package SideProject.CodeLingo.domain;

import java.util.List;

public class Quiz {

    public Long quizId;
    public String quizCategory;
    public Long quizLevel;
    public String quizScript;
    public String quizImgUrl;
    public List<String> quizExamples;
//
//    public Quiz(Long quizId, String quizCategory, Long quizLevel, String quizScript, List<String> quizExamples) {
//        this.quizId = quizId;
//        this.quizCategory = quizCategory;
//        this.quizLevel = quizLevel;
//        this.quizScript = quizScript;
//        this.quizExamples = quizExamples;
//    }

    public List<String> getQuizExamples() {
        return quizExamples;
    }

    public void setQuizExamples(List<String> quizExamples) {
        this.quizExamples = quizExamples;
    }

    public String getQuizScript() {
        return quizScript;
    }

    public void setQuizScript(String quizScript) {
        this.quizScript = quizScript;
    }


    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public String getQuizCategory() {
        return quizCategory;
    }

    public void setQuizCategory(String quizCategory) {
        this.quizCategory = quizCategory;
    }

    public String getQuizImgUrl() {
        return quizImgUrl;
    }

    public void setQuizImgUrl(String quizImgUrl) {
        this.quizImgUrl = quizImgUrl;
    }

    public Long getQuizLevel() {
        return quizLevel;
    }

    public void setQuizLevel(Long quizLevel) {
        this.quizLevel = quizLevel;
    }

}

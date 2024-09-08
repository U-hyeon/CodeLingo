package SideProject.CodeLingo.domain;

import java.util.List;

public class Quiz {

    public Long quizId;
    public String quizCategory;
    public Long quizLevel;
    public String script;
    public String quizImgUrl;
    public List<String> examples;
//
//    public Quiz(Long quizId, String quizCategory, Long quizLevel, String script, List<String> examples) {
//        this.quizId = quizId;
//        this.quizCategory = quizCategory;
//        this.quizLevel = quizLevel;
//        this.script = script;
//        this.examples = examples;
//    }

    public List<String> getExamples() {
        return examples;
    }

    public void setExamples(List<String> examples) {
        this.examples = examples;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
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

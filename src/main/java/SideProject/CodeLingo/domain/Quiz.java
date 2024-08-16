package SideProject.CodeLingo.domain;

import java.util.List;

public class Quiz {

    public Long quizId;
    public String quizLanguage;
    public Long quizLevel;
    public String script;
    public List<String> examples;
//
//    public Quiz(Long quizId, String quizLanguage, Long quizLevel, String script, List<String> examples) {
//        this.quizId = quizId;
//        this.quizLanguage = quizLanguage;
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

    public String getQuizLanguage() {
        return quizLanguage;
    }

    public void setQuizLanguage(String quizLanguage) {
        this.quizLanguage = quizLanguage;
    }

    public Long getQuizLevel() {
        return quizLevel;
    }

    public void setQuizLevel(Long quizLevel) {
        this.quizLevel = quizLevel;
    }

}

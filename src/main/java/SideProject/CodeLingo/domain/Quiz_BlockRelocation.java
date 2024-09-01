package SideProject.CodeLingo.domain;

import java.util.List;

public class Quiz_BlockRelocation extends Quiz {
    public List<String> getBlockContent() {
        return blockContent;
    }

    public void setBlockContent(List<String> blockContent) {
        this.blockContent = blockContent;
    }

    public List<String> getBlockAnswer() {
        return blockAnswer;
    }

    public void setBlockAnswer(List<String> blockAnswer) {
        this.blockAnswer = blockAnswer;
    }

    public List<String> blockContent; // NULL if its blank(=for question)
    public List<String> blockAnswer; // correct answer of quiz in order. Correct position is where it's NULL in blockContent

}

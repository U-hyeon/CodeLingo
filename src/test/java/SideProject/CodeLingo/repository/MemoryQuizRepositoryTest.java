package SideProject.CodeLingo.repository;

import SideProject.CodeLingo.domain.Quiz;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MemoryQuizRepositoryTest {
    MemoryQuizRepository repository = new MemoryQuizRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Quiz quiz = new Quiz();
        List<String> examples = new ArrayList<String>(){
            {
                add("ex1");
                add("ex2");
                add("ex3");
            }
        };

        quiz.setScript("This is JAVA test quiz.");
        quiz.setQuizCategory("JAVA");
        quiz.setQuizLevel(3L);
        quiz.setExamples(examples);

        repository.save(quiz);
        Quiz result = repository.findByQuizId(quiz.getQuizId()).get();

        Assertions.assertThat(quiz).isEqualTo(result);
    }

    @Test
    public void findByQuizId() {

    }

    @Test
    public void findByCategory() {

    }

//    @Test
//    public void findByLevel() {
//        Quiz quiz1 = new Quiz();
//        quiz1. setScript("This is spring quiz1.");
//        quiz1.setQuizLevel(3L);
//        repository.save(quiz1);
//
//        Quiz quiz2 = new Quiz();
//        quiz2. setScript("This is spring quiz2.");
//        quiz2.setQuizLevel(3L);
//        repository.save(quiz2);
//
//        List<Quiz> result = repository.findByLevel(3L).get();
//
//        Assertions.assertThat(result.size()).isEqualTo(2);
//    }

    @Test
    public void findAll() {
        Quiz quiz1 = new Quiz();
        quiz1. setScript("This is spring quiz1.");
        repository.save(quiz1);

        Quiz quiz2 = new Quiz();
        quiz2. setScript("This is spring quiz2.");
        repository.save(quiz2);

        List<Quiz> result = repository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);
    }

}

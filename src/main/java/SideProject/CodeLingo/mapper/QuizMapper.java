package SideProject.CodeLingo.mapper;

import SideProject.CodeLingo.domain.Quiz;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuizMapper {
    @Select("SELECT * FROM QUIZ_TABLE WHERE QUIZ_ID IS #{quizId}")
    Quiz getOneQuiz(@Param("quizId") Long quizId);

    @Select("SELECT * FROM QUIZ_TABLE WHERE QUIZ_CATEGORY IS #{quizCategory}")
    List<Quiz> getAllQuiz_category(@Param("quizCategory") Long quizCategory);

    @Select("SELECT * FROM QUIZ_TABLE " +
            "WHERE QUIZ_CATEGORY IS #{quizCategory} " +
            "AND QUIZ_LEVEL IS #{quizLevel}")
    List<Quiz> getAllQuiz_level(
            @Param("quizCategory") Long quizCategory,
            @Param("quizLevel") Long quizLevel
    );

    @Insert("INSERT INTO QUIZ_TABLE " +
            "VALUES(" +
            "#{quizId}, #{quizCategory}, #{quizLevel}, " +
            "#{quizScript}, #{quizImgUrl}, #{quizExamples}" +
            ")")
    int insertQuiz(
            @Param("quizId") Long quizId,
            @Param("quizCategory") String quizCategory,
            @Param("quizLevel") Long quizLevel,
            @Param("quizScript") String quizScript,
            @Param("quizExamples") List<String> quizExamples
    );

    @Insert("INSERT INTO QUIZ_BLOCK_RELOCATION_DETAIL_TABLE" +
            "VALUES( #{quizId}, #{blockContent}, #{blockAnswer} )")
    int insertQuizDetail_blockRelocation(
            @Param("quizId") Long quizId,
            @Param("blockContent") List<String> blockContent,
            @Param("blockAnswer") List<String> blockAnswer
    );

    @Insert("INSERT INTO QUIZ_SINGLE_ANSWER_TABLE" +
            "VALUES( #{quizId}, #{answer} )")
    int insertQuizDetail_single(@Param("quizId") Long quizId, @Param("answer") String answer);

    @Update("UPDATE QUIZ_TABLE" +
            "SET " +
            "WHERE QUIZ_ID IS #{quizId}")
    int updateQuiz();

    @Update("UPDATE QUIZ_BLOCK_RELOCATION_DETAIL_TABLE" +
            "SET" +
            "WHERE QUIZ_ID IS #{quizId}")
    int updateQuizDetail_blockRelocation();

    @Update("UPDATE QUIZ_SINGLE_ANSWER_TABLE" +
            "SET" +
            "WHERE QUIZ_ID IS #{quizId}")
    int updateQuizDetail_singleAnswer();

    /** DELETE FROM QUIZ_TABLE */
    @Delete("DELETE FROM QUIZ_TABLE WHERE QUIZ_ID IS #{quizId}")
    int deleteOneQuiz(@Param("quizId") Long quizId);

    @Delete("DELETE FROM QUIZ_TABLE WHERE QUIZ_CATEGORY IS #{quizCategory}")
    int deleteAllQuiz_category();

    @Delete("DELETE FROM QUIZ_TABLE " +
            "WHERE QUIZ_CATEGORY IS #{quizCategory} " +
            "AND QUIZ_LEVEL IS #{quizLevel}")
    int deleteAllQuiz_level();

    /** DELETE FROM QUIZ_BLOCK_RELOCATION_TABLE */
    @Delete("DELETE FROM QUIZ_BLOCK_RELOCATION_DETAIL_TABLE WHERE QUIZ_ID IS #{quizId}")
    int deleteOneQuiz_blockRelocation(@Param("quizId") Long quizId);

    @Delete("DELETE FROM QUIZ_BLOCK_RELOCATION_DETAIL_TABLE " +
            "WHERE (SELECT QUIZ_CATEGORY FROM QUIZ_TABLE WHERE QUIZ_ID IS #{quizId}) " +
            "IS #{quizCategory}")
    int deleteALLQuiz_category_blockRelocation(
            @Param("quizId") Long quizId,
            @Param("quizCategory") String quizCategory
    );

    @Delete("DELETE FROM QUIZ_BLOCK_RELOCATION_DETAIL_TABLE " +
            "WHERE (SELECT QUIZ_CATEGORY FROM QUIZ_TABLE WHERE QUIZ_ID IS #{quizId}) " +
            "IS #{quizCategory} " +
            "AND (SELECT QUIZ_LEVEL FROM QUIZ_TABLE WHERE QUIZ_ID IS #{quizId}) " +
            "IS #{quizLevel}")
    int deleteALLQuiz_level_blockRelocation(
            @Param("quizId") Long quizId,
            @Param("quizCategory") String quizCategory,
            @Param("quizLevel") Long quizLevel
    );

    /** DELETE FROM QUIZ_SINGLE_ANSWER_TABLE */
    @Delete("DELETE FROM QUIZ_SINGLE_ANSWER_TABLE WHERE QUIZ_ID IS #{quizId}")
    int deleteOneQuiz_singleAnswer(@Param("quizId") Long quizId);

    @Delete("DELETE FROM QUIZ_SINGLE_ANSWER_TABLE " +
            "WHERE (SELECT QUIZ_CATEGORY FROM QUIZ_TABLE WHERE QUIZ_ID IS #{quizId}) " +
            "IS #{quizCategory}")
    int deleteALLQuiz_category_singleAnswer(
            @Param("quizId") Long quizId,
            @Param("quizCategory") String quizCategory
    );

    @Delete("DELETE FROM QUIZ_SINGLE_ANSWER_TABLE " +
            "WHERE (SELECT QUIZ_CATEGORY FROM QUIZ_TABLE WHERE QUIZ_ID IS #{quizId}) " +
            "IS #{quizCategory} " +
            "AND (SELECT QUIZ_LEVEL FROM QUIZ_TABLE WHERE QUIZ_ID IS #{quizId}) " +
            "IS #{quizLevel}")
    int deleteALLQuiz_level_singleAnswer(
            @Param("quizId") Long quizId,
            @Param("quizCategory") String quizCategory,
            @Param("quizLevel") Long quizLevel
    );
}

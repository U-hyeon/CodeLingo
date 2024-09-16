package SideProject.CodeLingo.mapper;

import SideProject.CodeLingo.domain.Quiz;
import SideProject.CodeLingo.domain.Quiz_BlockRelocation;
import SideProject.CodeLingo.domain.Quiz_SingleAnswer;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuizMapper {
/** SELECT */
/** -SELECT ONE */
    @Select("SELECT * FROM QUIZ_TABLE WHERE QUIZ_ID IS #{quizId}")
    Quiz getOneQuiz(@Param("quizId") Long quizId);
    @Select("SELECT * FROM QUIZ_DETAIL_BLOCK_RELOCATION_TABLE WHERE QUIZ_ID IS #{quizId}")
    Quiz_BlockRelocation getOneQuiz_detail_blockRelocation(@Param("quizId") Long quizId);
    @Select("SELECT * FROM QUIZ_DETAIL_SINGLE_ANSWER_TABLE WHERE QUIZ_ID IS #{quizId}")
    Quiz_SingleAnswer getOneQuiz_detail_singleAnswer(@Param("quizId") Long quizId);
/** -SELECT LIST */
    @Select("SELECT * FROM QUIZ_TABLE")
    List<Quiz> getAllQuiz();
    @Select("SELECT * FROM QUIZ_TABLE WHERE QUIZ_CATEGORY IS #{quizCategory}")
    List<Quiz> getAllQuiz_category(@Param("quizCategory") String quizCategory);
    @Select("SELECT * FROM QUIZ_TABLE " +
            "WHERE QUIZ_CATEGORY IS #{quizCategory} " +
            "AND QUIZ_LEVEL IS #{quizLevel}")
    List<Quiz> getAllQuiz_level(
            @Param("quizCategory") String quizCategory,
            @Param("quizLevel") Long quizLevel
    );
/** SELECT DISTINCT */
    @Select("SELECT DISTINCT QUIZ_CATEGORY FROM QUIZ_TABLE")
    List<String> getAllCategory();
    @Select("SELECT DISTINCT QUIZ_LEVEL FROM QUIZ_TABLE WHERE QUIZ_CATEGORY IS #{quizCategory}")
    List<Long> getAllLevel_category(@Param("quizCategory") String quizCategory);

/** INSERT */
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
            @Param("quizImgUrl") String quizImgUrl,
            @Param("quizExamples") List<String> quizExamples
    );
    @Insert("INSERT INTO QUIZ_DETAIL_BLOCK_RELOCATION_TABLE" +
            "VALUES( #{quizId}, #{blockContent}, #{blockAnswer} )")
    int insertQuizDetail_blockRelocation(
            @Param("quizId") Long quizId,
            @Param("blockContent") List<String> blockContent,
            @Param("blockAnswer") List<String> blockAnswer
    );
    @Insert("INSERT INTO QUIZ_DETAIL_SINGLE_ANSWER_TABLE" +
            "VALUES( #{quizId}, #{answer} )")
    int insertQuizDetail_singleAnswer(@Param("quizId") Long quizId, @Param("answer") String answer);

/** UPDATE */
    @Update("UPDATE QUIZ_TABLE" +
            "SET " +
            "QUIZ_CATEGORY=#{quizCategory}, " +
            "QUIZ_LEVEL=#{quizLevel}, " +
            "QUIZ_SCRIPT=#{quizScript}, " +
            "QUIZ_IMG_URL=#{quizImgUrl}, " +
            "QUIZ_EXAMPLES=#{quizExamples}" +
            "WHERE QUIZ_ID IS #{quizId}")
    int updateQuiz(
            @Param("quizId") Long quizId,
            @Param("quizCategory") String quizCategory,
            @Param("quizLevel") Long quizLevel,
            @Param("quizScript") String quizScript,
            @Param("quizImgUrl") String quizImgUrl,
            @Param("quizExamples") List<String> quizExamples
    );
    @Update("UPDATE QUIZ_DETAIL_BLOCK_RELOCATION_TABLE" +
            "SET" +
            "QUIZ_BLOCK_CONTENT=#{quizBlockContent}, " +
            "QUIZ_BLOCK_ANSWER=#{quizBlockAnswer}" +
            "WHERE QUIZ_ID IS #{quizId}")
    int updateQuiz_detail_blockRelocation(
            @Param("quizId") Long quizId,
            @Param("quizBlockContent") List<String> quizBlockContent,
            @Param("quizBlockAnswer") List<String> quizBlockAnswer
    );
    @Update("UPDATE QUIZ_DETAIL_SINGLE_ANSWER_TABLE" +
            "SET QUIZ_ANSWER=#{quizAnswer}" +
            "WHERE QUIZ_ID IS #{quizId}")
    int updateQuiz_detail_singleAnswer(
            @Param("quizId") Long quizId,
            @Param("quizAnswer") Long quizAnswer
    );

/** DELETE */
/** DELETE FROM QUIZ_TABLE */
    @Delete("DELETE FROM QUIZ_TABLE WHERE QUIZ_ID IS #{quizId}")
    int deleteOneQuiz(@Param("quizId") Long quizId);

    @Delete("DELETE FROM QUIZ_TABLE WHERE QUIZ_CATEGORY IS #{quizCategory}")
    int deleteAllQuiz_category(@Param("quizCategory") String quizCategory);

    @Delete("DELETE FROM QUIZ_TABLE " +
            "WHERE QUIZ_CATEGORY IS #{quizCategory} " +
            "AND QUIZ_LEVEL IS #{quizLevel}")
    int deleteAllQuiz_level(
            @Param("quizCategory") String quizCategory,
            @Param("quizLevel") Long quizLevel
    );

/** DELETE FROM QUIZ_BLOCK_RELOCATION_TABLE */
    @Delete("DELETE FROM QUIZ_DETAIL_BLOCK_RELOCATION_TABLE WHERE QUIZ_ID IS #{quizId}")
    int deleteOneQuiz_blockRelocation(@Param("quizId") Long quizId);

    @Delete("DELETE FROM QUIZ_DETAIL_BLOCK_RELOCATION_TABLE " +
            "WHERE QUIZ_ID IN " +
            "( SELECT QUIZ_ID FROM QUIZ_TABLE WHERE QUIZ_CATEGORY IS #{quizCategory} )")
    int deleteALLQuiz_category_blockRelocation(
            @Param("quizCategory") String quizCategory
    );

    @Delete("DELETE FROM QUIZ_DETAIL_BLOCK_RELOCATION_TABLE " +
            "WHERE QUIZ_ID IN" +
            "( SELECT QUIZ_ID FROM QUIZ_TABLE WHERE QUIZ_CATEGORY IS #{quizCategory} " +
            "AND QUIZ_LEVEL IS #{quizLevel} )")
    int deleteALLQuiz_level_blockRelocation(
            @Param("quizCategory") String quizCategory,
            @Param("quizLevel") Long quizLevel
    );

/** DELETE FROM QUIZ_DETAIL_SINGLE_ANSWER_TABLE */
    @Delete("DELETE FROM QUIZ_DETAIL_SINGLE_ANSWER_TABLE WHERE QUIZ_ID IS #{quizId}")
    int deleteOneQuiz_singleAnswer(@Param("quizId") Long quizId);

    @Delete("DELETE FROM QUIZ_DETAIL_SINGLE_ANSWER_TABLE " +
            "WHERE QUIZ_ID IN" +
            "( SELECT QUIZ_ID FROM QUIZ_TABLE WHERE QUIZ_CATEGORY IS #{quizCategory} )")
    int deleteALLQuiz_category_singleAnswer(
            @Param("quizCategory") String quizCategory
    );

    @Delete("DELETE FROM QUIZ_DETAIL_SINGLE_ANSWER_TABLE " +
            "WHERE QUIZ_ID IN" +
            "( SELECT QUIZ_ID FROM QUIZ_TABLE WHERE QUIZ_CATEGORY IS #{quizCategory} " +
            "AND QUIZ_LEVEL IS #{quizLevel} )")
    int deleteALLQuiz_level_singleAnswer(
            @Param("quizCategory") String quizCategory,
            @Param("quizLevel") Long quizLevel
    );
}

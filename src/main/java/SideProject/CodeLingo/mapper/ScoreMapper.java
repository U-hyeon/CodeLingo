package SideProject.CodeLingo.mapper;

import SideProject.CodeLingo.domain.Score;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ScoreMapper {
    /** 특정 quiz에 대한 해당 user의 점수 조회*/
    @Select("SELECT QUIZ_SCORE FROM SCORE_TABLE WHERE USER_ID IS #{userId} AND QUIZ_ID IS #{quizId}")
    Long getQuizScore(@Param("userId") Long userId, @Param("quizId") Long quizId);

    /** User의 모든 점수 조회, 진척도 평가에 사용  */
    @Select("SELECT * FROM SCORE_TABLE WHERE USER_ID IS #{userId}")
    List<Score> getAllScores_ofUser(@Param("userId") Long userId);

    /** 모든 User의 해당 Quiz 점수 조회, 정답률 확인에 사용 */
    @Select("SELECT * FROM SCORE_TABLE WHERE QUIZ_ID IS #{quizId}")
    List<Score> getAllScores_ofQuiz(@Param("quizId") Long quizId);

    /** 신규 회원가입시 전체 퀴즈에 대한 점수를 일단 저장할 것, 쓰레기값을 넣어 진행하지 않았음을 구별 */
    @Insert("INSERT INTO SCORE_TABLE VALUES(#{scoreId},#{userId},#{quizId}),#{quizScore}")
    int insertQuizScore(
            @Param("scoreId") Long scoreId,
            @Param("userId") Long userId,
            @Param("quizId") Long quizId,
            @Param("quizScore") Long quizScore
    );

    /** User의 해당 Quiz에 대한 점수 갱신 */
    @Update("UPDATE SCORE_TABLE " +
            "SET QUIZ_SCORE=#{quizScore}" +
            "WHERE USER_ID IS #{userId} AND QUIZ_ID IS #{quizId}")
    int updateQuizScore(
            @Param("userId") Long userId,
            @Param("quizId") Long quizId,
            @Param("quizScore") Long quizScore
    );

    /** User의 모든 데이터 삭제, User 탈퇴시 */
    @Delete("DELETE FROM SCORE_TABLE WHERE USER_ID IS #{userId}")
    int deleteAllScores_ofUser(@Param("userId") Long userId);

    /** Quiz의 모든 데이터 삭제, Quiz가 삭제되었을 때 */
    @Delete("DELETE FROM SCORE_TABLE WHERE QUIZ_ID IS #{quizId}")
    int deleteAllScores_ofQuiz(@Param("quizId") Long quizId);
}

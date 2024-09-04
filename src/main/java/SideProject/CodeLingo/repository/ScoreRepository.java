package SideProject.CodeLingo.repository;

import SideProject.CodeLingo.domain.Score;

import java.util.List;
import java.util.Optional;

public interface ScoreRepository {
    /** Score 클래스를 통한 점수 저장 */
    Score save(Score score);
    /** userId, quizId, quizScore를 통한 점수 저장 */
    Score save(Long scoreId, Long userId, Long quizId, Long quizScore);
    Optional< List<Score> > findAllScoreOfUser(Long userId);
    Optional< List<Score> > findAllScoreOfQuiz(Long quizId);
}

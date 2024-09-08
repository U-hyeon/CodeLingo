package SideProject.CodeLingo.repository;

import SideProject.CodeLingo.domain.Score;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MemoryScoreRepository implements ScoreRepository {

    private static List<Score> scoreRepository;
    private static long sequence = 0L;

    /** Score 클래스를 통한 점수 저장 */
    @Override
    public Score save(Score score) {

        /**
         * 중복검사 후 중복시 덮어쓰기
         */

        scoreRepository.add(score);
        return score;
    }

    /** userId, quizId, quizScore를 통한 점수 저장 */
    @Override
    public Score save(Long scoreId, Long userId, Long quizId, Long quizScore) {

        /**
         * 중복검사 후 중복시 덮어쓰기
         */

        Score score = new Score();

        score.setScoreId(scoreId);
        score.setUserId(userId);
        score.setQuizId(quizId);
        score.setQuizScore(quizScore);

        scoreRepository.add(score);

        return score;
    }

    /** 모든 퀴즈에 대한 해당 user의 점수 조회 */
    @Override
    public Optional<List<Score>> findAllScoreOfUser(Long userId) {
        // not yet
        return Optional.empty();
    }

    /** 해당 퀴즈에 대한 모든 user의 점수 조회 */
    @Override
    public Optional<List<Score>> findAllScoreOfQuiz(Long quizId) {
        // not yet
        return Optional.empty();
    }

}

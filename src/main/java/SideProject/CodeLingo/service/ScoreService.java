package SideProject.CodeLingo.service;

import SideProject.CodeLingo.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    private final ScoreRepository scoreRepository;

    @Autowired
    public ScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    /** 해당 문제의 정답률 구하기 */
    /** 해당 카테고리에 대한 유저의 성적 */
    /** 해당 카테고리, 레벨에 대한 유저의 성적 */
}

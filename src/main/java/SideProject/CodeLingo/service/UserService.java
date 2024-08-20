package SideProject.CodeLingo.service;

import SideProject.CodeLingo.domain.User;
import SideProject.CodeLingo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /** 회원가입 */
    public Long Join(User user) {
        validateDuplicateUser(user);

        userRepository.save(user);
        return user.getUserId();
    }

    /** 회원 중복검사(이름) */
    private void validateDuplicateUser(User user) {
        userRepository.findByUserName(user.getUserName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /**
     * 전체 회원 조회
     * @return
     */
    public List<User> findMembers() {
        return userRepository.findAll();
    }

    /** 단일 회원 조회 (userId) */
    public Optional<User> findOne(Long userId) {
        return userRepository.findByUserId(userId);
    }
}

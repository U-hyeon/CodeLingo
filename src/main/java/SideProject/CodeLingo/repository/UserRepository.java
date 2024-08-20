package SideProject.CodeLingo.repository;

import SideProject.CodeLingo.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findByUserId(Long userId);
    Optional<User> findByUserName(String userName);
    List<User> findAll();
}

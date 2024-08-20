package SideProject.CodeLingo.repository;

import SideProject.CodeLingo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryUserRepository implements UserRepository {

    private static Map<Long, User> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public User save(User user) {
        user.setUserId(++sequence);
        store.put(user.getUserId(), user);
        return user;
    }

    @Override
    public Optional<User> findByUserId(Long userId) {
        return Optional.ofNullable(store.get(userId));
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }
}

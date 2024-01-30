package umc.study.user.domain;

import umc.study.user.domain.info.Category;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepository {
    void save(User user);

    Optional<User> findById(long userId);
    Optional<Category> findCategoryById(Long categoryId);
}

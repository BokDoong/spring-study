package umc.study.user.domain;

import umc.study.user.domain.info.Category;

import java.util.Optional;

public interface UserRepository {
    void save(User user);

    Optional<Category> findCategoryById(Long categoryId);
}

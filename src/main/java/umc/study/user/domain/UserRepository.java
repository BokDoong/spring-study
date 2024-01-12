package umc.study.user.domain;

import java.util.Optional;

public interface UserRepository {
    void save(User user);

    Optional<FoodCategory> findCategoryById(Long categoryId);
}

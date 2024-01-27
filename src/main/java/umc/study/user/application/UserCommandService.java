package umc.study.user.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.exception.BusinessException;
import umc.study.exception.code.ErrorCode;
import umc.study.user.application.dto.UserCommandMapper;
import umc.study.user.application.dto.request.UserJoinCommand;
import umc.study.user.domain.info.Category;
import umc.study.user.domain.User;
import umc.study.user.domain.info.UserPrefer;
import umc.study.user.domain.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCommandService {

    private final UserCommandMapper userCommandMapper;
    private final UserRepository userRepository;

    @Transactional
    public void join(UserJoinCommand userJoinCommand) {
        User user = toUser(userJoinCommand);
        List<Category> foodCategories = toFoodCategories(userJoinCommand);

        List<UserPrefer> userPrefers = foodCategories.stream()
                .map(foodCategory -> userCommandMapper.toEntity(user, foodCategory)).collect(Collectors.toList());
        addUserPrefersToUserAndCategories(user, foodCategories, userPrefers);

        userRepository.save(user);
    }

    private void addUserPrefersToUserAndCategories(User user, List<Category> foodCategories, List<UserPrefer> userPrefers) {
        userPrefers.forEach(user::addUserPrefer);
        userPrefers.forEach(userPrefer ->
                foodCategories.forEach(foodCategory -> foodCategory.addUserPrefer(userPrefer))
        );
    }

    private User toUser(UserJoinCommand userJoinCommand) {
        return userCommandMapper.toEntity(userJoinCommand);
    }

    private List<Category> toFoodCategories(UserJoinCommand userJoinCommand) {
        return userJoinCommand.getCategoryIds().stream()
                .map(this::findFoodCategory).collect(Collectors.toList());
    }

    private Category findFoodCategory(Long categoryId) {
        return userRepository.findCategoryById(categoryId)
                .orElseThrow(() -> new BusinessException(ErrorCode.CATEGORY_NOT_FOUND));
    }
}

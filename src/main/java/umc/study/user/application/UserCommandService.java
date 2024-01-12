package umc.study.user.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.exception.BusinessException;
import umc.study.exception.code.ErrorCode;
import umc.study.user.application.dto.UserCommandMapper;
import umc.study.user.application.dto.request.UserJoinCommand;
import umc.study.user.domain.FoodCategory;
import umc.study.user.domain.User;
import umc.study.user.domain.UserPrefer;
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
        List<FoodCategory> foodCategories = toFoodCategories(userJoinCommand);

        List<UserPrefer> userPrefers = userCommandMapper.toEntities(user, foodCategories);
        addUserPrefersToUserAndCategories(user, foodCategories, userPrefers);

        userRepository.save(user);
    }

    private void addUserPrefersToUserAndCategories(User user, List<FoodCategory> foodCategories, List<UserPrefer> userPrefers) {
        userPrefers.forEach(user::addUserPrefer);
        userPrefers.forEach(userPrefer ->
                foodCategories.forEach(foodCategory ->
                        foodCategory.addUserPrefer(userPrefer))
        );
    }

    private User toUser(UserJoinCommand userJoinCommand) {
        return userCommandMapper.toEntity(userJoinCommand);
    }

    private List<FoodCategory> toFoodCategories(UserJoinCommand userJoinCommand) {
        return userJoinCommand.getCategoryIds().stream()
                .map(this::findFoodCategory).collect(Collectors.toList());
    }

    private FoodCategory findFoodCategory(Long categoryId) {
        return userRepository.findCategoryById(categoryId)
                .orElseThrow(() -> new BusinessException(ErrorCode.CATEGORY_NOT_FOUND));
    }
}

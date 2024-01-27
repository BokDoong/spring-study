package umc.study.user.application.dto;

import org.mapstruct.Mapper;
import umc.study.user.application.dto.request.UserJoinCommand;
import umc.study.user.domain.info.Category;
import umc.study.user.domain.User;
import umc.study.user.domain.info.UserPrefer;

@Mapper(componentModel = "spring")
public interface UserCommandMapper {

    User toEntity(UserJoinCommand userJoinCommand);

    UserPrefer toEntity(User user, Category category);

//    default List<UserPrefer> toEntities(User user, List<FoodCategory> foodCategories) {
//        return foodCategories.stream()
//                .map(foodCategory -> makeUserPrefer(user, foodCategory))
//                .collect(Collectors.toList());
//    }
//
//    private UserPrefer makeUserPrefer(User user, FoodCategory foodCategory) {
//        return UserPrefer.builder()
//                .user(user)
//                .foodCategory(foodCategory)
//                .build();
//    }
}

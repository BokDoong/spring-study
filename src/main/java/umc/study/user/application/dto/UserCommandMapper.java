package umc.study.user.application.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import umc.study.user.application.dto.request.UserJoinCommand;
import umc.study.user.domain.FoodCategory;
import umc.study.user.domain.User;
import umc.study.user.domain.UserPrefer;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserCommandMapper {
    UserCommandMapper INSTANCE = Mappers.getMapper(UserCommandMapper.class);

    User toEntity(UserJoinCommand userJoinCommand);

    // UserPrefer toEntity(User user, FoodCategory foodCategory);
    default List<UserPrefer> toEntities(User user, List<FoodCategory> foodCategories) {
        return foodCategories.stream()
                .map(foodCategory -> new UserPrefer(user, foodCategory))
                .collect(Collectors.toList());
    }
}

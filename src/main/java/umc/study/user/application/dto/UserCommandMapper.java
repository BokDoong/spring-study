package umc.study.user.application.dto;

import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import umc.study.user.application.dto.request.UserJoinCommand;
import umc.study.user.domain.info.Category;
import umc.study.user.domain.User;
import umc.study.user.domain.info.UserPrefer;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserCommandMapper {

    UserCommandMapper INSTANCE = Mappers.getMapper(UserCommandMapper.class);

    User toEntity(UserJoinCommand userJoinCommand);

    UserPrefer toEntity(User user, Category category);

    default List<UserPrefer> toEntities(User user, List<Category> foodCategories) {
        return foodCategories.stream()
                .map(foodCategory -> createUserPrefer(user, foodCategory))
                .collect(Collectors.toList());
    }

    private UserPrefer createUserPrefer(User user, Category foodCategory) {
        return UserPrefer.builder()
                .user(user)
                .category(foodCategory)
                .build();
    }
}

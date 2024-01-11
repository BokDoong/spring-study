package umc.study.user.application.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import umc.study.user.application.dto.request.UserJoinCommand;
import umc.study.user.domain.User;

@Mapper(componentModel = "spring")
public interface UserCommandMapper {
    UserCommandMapper INSTANCE = Mappers.getMapper(UserCommandMapper.class);

    User toEntity(UserJoinCommand userJoinCommand);
}

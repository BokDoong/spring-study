package umc.study.user.infra.http.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import umc.study.user.application.dto.request.UserJoinCommand;
import umc.study.user.infra.http.dto.request.UserJoinDto;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {
    UserDtoMapper INSTANCE = Mappers.getMapper(UserDtoMapper.class);

    UserJoinCommand toCommand(UserJoinDto userJoinDto);
}

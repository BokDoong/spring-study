package umc.study.mission.infra.http.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import umc.study.mission.application.dto.request.MissionCreateCommand;
import umc.study.mission.infra.http.dto.request.MissionCreateDto;
import umc.study.store.domain.location.Region;

@Mapper(componentModel = "spring", imports = Region.class)
public interface MissionDtoMapper {

    MissionDtoMapper INSTANCE = Mappers.getMapper(MissionDtoMapper.class);

    MissionCreateCommand toCommand(MissionCreateDto missionCreateDto);
}

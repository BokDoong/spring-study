package umc.study.mission.application.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import umc.study.mission.application.dto.request.MissionCreateCommand;
import umc.study.mission.domain.Mission;
import umc.study.store.domain.Store;
import umc.study.store.domain.location.Region;

@Mapper(componentModel = "spring", imports = Region.class)
public interface MissionCommandMapper {

    MissionCommandMapper INSTANCE = Mappers.getMapper(MissionCommandMapper.class);

    Mission toEntity(Store store, MissionCreateCommand missionCreateCommand);
}

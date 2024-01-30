package umc.study.store.infra.http.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import umc.study.store.application.dto.request.ReviewCreateCommand;
import umc.study.store.application.dto.request.StoreCreateCommand;
import umc.study.store.infra.http.dto.request.ReviewCreateDto;
import umc.study.store.infra.http.dto.request.StoreRegisterDto;
import umc.study.store.domain.location.Region;

@Mapper(componentModel = "spring", imports = Region.class)
public interface StoreDtoMapper {
    StoreDtoMapper INSTANCE = Mappers.getMapper(StoreDtoMapper.class);

    @Mapping(target = "regionAddress", expression = "java(Region.extractTown(registerDto.getFirstAddress()))")
    StoreCreateCommand toCommand(StoreRegisterDto registerDto);

    ReviewCreateCommand toCommand(ReviewCreateDto reviewCreateDto);

}

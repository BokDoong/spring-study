package umc.study.store.application.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import umc.study.store.domain.Store;
import umc.study.store.domain.location.Region;
import umc.study.user.domain.info.Category;

@Mapper(componentModel = "spring")
public interface StoreCommandMapper {
    StoreCommandMapper INSTANCE = Mappers.getMapper(StoreCommandMapper.class);

    @Mapping(target = "name", source = "storeCreateCommand.name")
    Store toEntity(StoreCreateCommand storeCreateCommand, Category category, Region region);

}

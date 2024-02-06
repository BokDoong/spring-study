package umc.study.mission.infra.http.dto;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import umc.study.mission.application.dto.request.MissionCreateCommand;
import umc.study.mission.application.dto.request.MissionCreateCommand.MissionCreateCommandBuilder;
import umc.study.mission.infra.http.dto.request.MissionCreateDto;
import umc.study.store.domain.location.Region;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-06T11:11:55+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.5 (JetBrains s.r.o.)"
)
@Component
public class MissionDtoMapperImpl implements MissionDtoMapper {

    @Override
    public MissionCreateCommand toCommand(MissionCreateDto missionCreateDto) {
        if ( missionCreateDto == null ) {
            return null;
        }

        MissionCreateCommandBuilder missionCreateCommand = MissionCreateCommand.builder();

        missionCreateCommand.price( missionCreateDto.getPrice() );
        missionCreateCommand.content( missionCreateDto.getContent() );
        missionCreateCommand.deadline( missionCreateDto.getDeadline() );

        return missionCreateCommand.build();
    }
}

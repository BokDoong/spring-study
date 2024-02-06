package umc.study.mission.application.dto;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import umc.study.mission.application.dto.request.MissionCreateCommand;
import umc.study.mission.domain.Mission;
import umc.study.mission.domain.Mission.MissionBuilder;
import umc.study.store.domain.Store;
import umc.study.store.domain.location.Region;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-06T11:11:55+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.5 (JetBrains s.r.o.)"
)
@Component
public class MissionCommandMapperImpl implements MissionCommandMapper {

    @Override
    public Mission toEntity(Store store, MissionCreateCommand missionCreateCommand) {
        if ( store == null && missionCreateCommand == null ) {
            return null;
        }

        MissionBuilder mission = Mission.builder();

        if ( store != null ) {
            mission.store( store );
        }
        if ( missionCreateCommand != null ) {
            mission.content( missionCreateCommand.getContent() );
            mission.price( missionCreateCommand.getPrice() );
            mission.deadline( missionCreateCommand.getDeadline() );
        }

        return mission.build();
    }
}

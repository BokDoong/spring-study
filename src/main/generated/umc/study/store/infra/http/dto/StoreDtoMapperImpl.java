package umc.study.store.infra.http.dto;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import umc.study.store.application.dto.request.ReviewCreateCommand;
import umc.study.store.application.dto.request.ReviewCreateCommand.ReviewCreateCommandBuilder;
import umc.study.store.application.dto.request.StoreCreateCommand;
import umc.study.store.application.dto.request.StoreCreateCommand.StoreCreateCommandBuilder;
import umc.study.store.domain.location.Region;
import umc.study.store.infra.http.dto.request.ReviewCreateDto;
import umc.study.store.infra.http.dto.request.StoreRegisterDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-06T11:11:55+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.5 (JetBrains s.r.o.)"
)
@Component
public class StoreDtoMapperImpl implements StoreDtoMapper {

    @Override
    public StoreCreateCommand toCommand(StoreRegisterDto registerDto) {
        if ( registerDto == null ) {
            return null;
        }

        StoreCreateCommandBuilder storeCreateCommand = StoreCreateCommand.builder();

        storeCreateCommand.name( registerDto.getName() );
        storeCreateCommand.openTime( registerDto.getOpenTime() );
        storeCreateCommand.closeTime( registerDto.getCloseTime() );
        storeCreateCommand.firstAddress( registerDto.getFirstAddress() );
        storeCreateCommand.secondAddress( registerDto.getSecondAddress() );
        List<Long> list = registerDto.getCategoryIds();
        if ( list != null ) {
            storeCreateCommand.categoryIds( new ArrayList<Long>( list ) );
        }

        storeCreateCommand.regionAddress( Region.extractTown(registerDto.getFirstAddress()) );

        return storeCreateCommand.build();
    }

    @Override
    public ReviewCreateCommand toCommand(ReviewCreateDto reviewCreateDto) {
        if ( reviewCreateDto == null ) {
            return null;
        }

        ReviewCreateCommandBuilder reviewCreateCommand = ReviewCreateCommand.builder();

        reviewCreateCommand.content( reviewCreateDto.getContent() );
        reviewCreateCommand.rating( reviewCreateDto.getRating() );

        return reviewCreateCommand.build();
    }
}

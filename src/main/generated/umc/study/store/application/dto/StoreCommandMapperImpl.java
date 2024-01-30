package umc.study.store.application.dto;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import umc.study.store.domain.Store;
import umc.study.store.domain.Store.StoreBuilder;
import umc.study.store.domain.location.Region;
import umc.study.user.domain.info.Category;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-30T14:44:09+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.5 (JetBrains s.r.o.)"
)
@Component
public class StoreCommandMapperImpl implements StoreCommandMapper {

    @Override
    public Store toEntity(StoreCreateCommand storeCreateCommand, Category category, Region region) {
        if ( storeCreateCommand == null && category == null && region == null ) {
            return null;
        }

        StoreBuilder store = Store.builder();

        if ( storeCreateCommand != null ) {
            store.name( storeCreateCommand.getName() );
            store.openTime( storeCreateCommand.getOpenTime() );
            store.closeTime( storeCreateCommand.getCloseTime() );
            store.firstAddress( storeCreateCommand.getFirstAddress() );
            store.secondAddress( storeCreateCommand.getSecondAddress() );
        }
        if ( category != null ) {
            store.category( category );
        }
        if ( region != null ) {
            store.region( region );
        }

        return store.build();
    }
}

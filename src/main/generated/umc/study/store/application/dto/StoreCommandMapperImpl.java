package umc.study.store.application.dto;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import umc.study.store.application.dto.request.ReviewCreateCommand;
import umc.study.store.application.dto.request.StoreCreateCommand;
import umc.study.store.domain.Store;
import umc.study.store.domain.Store.StoreBuilder;
import umc.study.store.domain.location.Region;
import umc.study.store.domain.review.Review;
import umc.study.store.domain.review.Review.ReviewBuilder;
import umc.study.user.domain.User;
import umc.study.user.domain.info.Category;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-30T17:01:52+0900",
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

    @Override
    public Review toEntity(ReviewCreateCommand reviewCreateCommand, User user, Store store) {
        if ( reviewCreateCommand == null && user == null && store == null ) {
            return null;
        }

        ReviewBuilder review = Review.builder();

        if ( reviewCreateCommand != null ) {
            review.content( reviewCreateCommand.getContent() );
            review.rating( reviewCreateCommand.getRating() );
        }
        if ( user != null ) {
            review.user( user );
        }
        if ( store != null ) {
            review.store( store );
        }

        return review.build();
    }
}

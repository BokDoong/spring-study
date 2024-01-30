package umc.study.store.domain;

import umc.study.store.domain.location.Region;
import umc.study.store.domain.review.Review;

import java.util.Optional;

public interface StoreRepository {
    Optional<Store> findById(long storeId);

    Optional<Region> findRegion(String name);

    Region save(Region newRegion);

    void save(Store store);

    void save(Review review);
}

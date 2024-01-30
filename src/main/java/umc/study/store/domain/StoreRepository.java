package umc.study.store.domain;

import umc.study.store.domain.location.Region;

import java.util.Optional;

public interface StoreRepository {
    Optional<Store> find(long storeId);

    Optional<Region> findRegion(String name);

    void save(Region newRegion);

    void save(Store store);
}

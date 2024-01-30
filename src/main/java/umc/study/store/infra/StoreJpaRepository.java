package umc.study.store.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.store.domain.Store;
import umc.study.store.domain.StoreRepository;
import umc.study.store.domain.location.Region;
import umc.study.store.domain.review.Review;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class StoreJpaRepository implements StoreRepository {

    private final EntityManager em;

    @Override
    public Optional<Store> findById(long storeId) {
        return Optional.ofNullable(em.find(Store.class, storeId));
    }

    @Override
    public Optional<Region> findRegion(String name) {
        List<Region> regions = em.createQuery("select r from Region r" +
                        " where r.name = :regionName", Region.class
                )
                .setParameter("regionName", name)
                .getResultList();

        return regions.stream().findAny();
    }

    @Override
    public Region save(Region newRegion) {
        em.persist(newRegion);

        return newRegion;
    }

    @Override
    public void save(Store store) {
        em.persist(store);
    }

    @Override
    public void save(Review review) {
        em.persist(review);
    }
}

package umc.study.store.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.common.basetime.BaseTimeEntity;
import umc.study.store.domain.location.Address;
import umc.study.store.domain.location.Region;
import umc.study.store.domain.review.Review;
import umc.study.user.domain.info.Category;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Store extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Embedded
    private BusinessHours businessHours;
    @Embedded
    private Address address;
    @Embedded
    private Images images;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;
    @OneToMany(mappedBy = "store", cascade = CascadeType.REMOVE)
    private List<Review> reviews;

    @Builder
    public Store(String name, LocalTime openTime, LocalTime closeTime,
                 String firstAddress, String secondAddress, Category category, Region region) {
        this.name = name;
        this.businessHours = new BusinessHours(openTime, closeTime);
        this.address = new Address(firstAddress, secondAddress);
        this.category = category;
        this.region = region;
        images = new Images();
        reviews = new ArrayList<>();
    }

    public void addReview(Review review) {
        reviews.add(review);
    }
}

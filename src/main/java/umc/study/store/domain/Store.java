package umc.study.store.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.common.basetime.BaseTimeEntity;
import umc.study.store.domain.image.Images;
import umc.study.store.domain.location.Address;
import umc.study.store.domain.location.Coordinates;
import umc.study.store.domain.location.Region;
import umc.study.user.domain.info.Category;

import javax.persistence.*;

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
    @Column
    private boolean opened;
    @Embedded
    private Address address;
    @Embedded
    private Coordinates coordinates;
    @Embedded
    private Images images;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;
}

package umc.study.store.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.common.BaseTimeEntity;
import umc.study.store.domain.image.Images;
import umc.study.store.domain.location.Address;
import umc.study.store.domain.location.Coordinates;
import umc.study.store.domain.location.Region;
import umc.study.store.domain.sales.OperationTime;
import umc.study.store.domain.sales.StoreClosedDay;

import javax.persistence.*;
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
    private Images images;
    @Embedded
    private Address address;
    @Embedded
    private Coordinates coordinates;
    @Embedded
    private OperationTime operationTime;
    @Column
    private boolean opened;
    @Column(name = "rating")
    private Long rating;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<StoreClosedDay> storeClosedDays = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;
}

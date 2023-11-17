package umc.study.store.domain.sales;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ClosedDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "day")
    @Enumerated(EnumType.STRING)
    private Day day;

    @OneToMany(mappedBy = "closedDay", cascade = CascadeType.ALL)
    private List<StoreClosedDay> storeClosedDays = new ArrayList<>();
}

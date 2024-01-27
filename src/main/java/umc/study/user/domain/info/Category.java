package umc.study.user.domain.info;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.common.basetime.BaseTimeEntity;
import umc.study.store.domain.Store;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Category extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<UserPrefer> userPrefers = new ArrayList<>();
    @OneToMany(mappedBy = "category")
    private List<Store> stores = new ArrayList<>();

    @Builder
    public Category(String name) {
        this.name = name;
        this.userPrefers = new ArrayList<>();
    }

    public void addUserPrefer(UserPrefer userPrefer) {
        userPrefers.add(userPrefer);
    }
}

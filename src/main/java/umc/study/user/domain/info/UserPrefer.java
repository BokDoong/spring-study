package umc.study.user.domain.info;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.common.basetime.BaseTimeEntity;
import umc.study.user.domain.User;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserPrefer extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foodcategory_id")
    private Category category;

    @Builder
    public UserPrefer(User user, Category category) {
        this.user = user;
        this.category = category;
    }
}

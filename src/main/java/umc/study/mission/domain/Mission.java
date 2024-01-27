package umc.study.mission.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.common.basetime.BaseTimeEntity;
import umc.study.store.domain.Store;
import umc.study.user.domain.User;
import umc.study.user.domain.UserMission;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Mission extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "content")
    private String content;
    @Embedded
    private Compensation compensation;
    @Column(name = "deadline")
    private LocalDateTime deadline;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="store_id")
    private Store store;

    @Builder
    public Mission(String content, int price, LocalDateTime deadline) {
        this.content = content;
        this.compensation = new Compensation(price);
        this.deadline = deadline;
    }
}

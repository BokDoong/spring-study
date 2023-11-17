package umc.study.mission.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.common.BaseTimeEntity;

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
    @Column(name = "store_id")
    private Long storeId;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<MissionUser> missionUsers = new ArrayList<>();

    @Builder
    public Mission(String content, int price, LocalDateTime deadline, Long storeId) {
        this.content = content;
        this.compensation = new Compensation(price);
        this.deadline = deadline;
        this.storeId = storeId;
    }
}

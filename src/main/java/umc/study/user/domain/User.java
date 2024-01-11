package umc.study.user.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.common.BaseTimeEntity;
import umc.study.mission.domain.MissionUser;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Embedded
    private Address address;
    @Column(name="birthdate")
    private LocalDateTime birthDate;
    @Column(name="point")
    private int point;
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<MissionUser> missionUsers = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<UserPrefer> userPrefers = new ArrayList<>();
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserImage userImage = new UserImage();

    @Builder
    public User(String name, String nickname, String email, String password, String phoneNumber,
                LocalDateTime birthDate, String firstAddress, String secondAddress) {
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.address = new Address(firstAddress, secondAddress);
        this.point = 0;
        this.role = Role.USER;
        this.missionUsers = new ArrayList<>();
        this.userPrefers = new ArrayList<>();
    }
}

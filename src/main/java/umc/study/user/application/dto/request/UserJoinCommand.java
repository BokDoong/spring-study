package umc.study.user.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class UserJoinCommand {

    private String name;
    private String nickname;
    private String email;
    private String password;
    private String phoneNumber;
    private String firstAddress;
    private String secondAddress;
    private LocalDateTime birthDate;
}

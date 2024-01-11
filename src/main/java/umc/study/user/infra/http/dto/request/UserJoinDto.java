package umc.study.user.infra.http.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserJoinDto {
    @NotBlank(message = "username is blank")
    private String name;
    @NotBlank(message = "nickname is blank")
    private String nickname;
    @NotBlank(message = "email is blank")
    private String email;
    @NotBlank(message = "password is blank")
    private String password;
    @NotBlank(message = "phoneNumber is blank")
    private String phoneNumber;
    @NotBlank(message = "firstAddress is blank")
    private String firstAddress;
    @NotBlank(message = "secondAddress is blank")
    private String secondAddress;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private LocalDateTime birthDate;
}

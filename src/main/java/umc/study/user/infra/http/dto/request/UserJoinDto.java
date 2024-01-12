package umc.study.user.infra.http.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

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
    @NotNull(message = "genderId is null")
    private Integer genderId;
    @NotNull(message = "categoryId is null")
    private List<Long> categoryIds;
    private String phoneNumber;
    private String firstAddress;
    private String secondAddress;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private LocalDateTime birthDate;
}

package umc.study.user.infra.http;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.user.application.UserCommandService;
import umc.study.user.infra.http.dto.UserDtoMapper;
import umc.study.user.infra.http.dto.request.UserJoinDto;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserDtoMapper userDtoMapper;
    private final UserCommandService userCommandService;

    @PostMapping()
    public void join(@RequestBody @Valid UserJoinDto userJoinDto) {
        userCommandService.join(userDtoMapper.toCommand(userJoinDto));
    }
}

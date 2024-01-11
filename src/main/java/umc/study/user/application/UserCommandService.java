package umc.study.user.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.user.application.dto.UserCommandMapper;
import umc.study.user.application.dto.request.UserJoinCommand;
import umc.study.user.domain.UserRepository;

@Service
@RequiredArgsConstructor
public class UserCommandService {

    private final UserCommandMapper userCommandMapper;
    private final UserRepository userRepository;

    @Transactional
    public void join(UserJoinCommand userJoinCommand) {
        System.out.println(userJoinCommand);
        userRepository.save(userCommandMapper.toEntity(userJoinCommand));
    }
}

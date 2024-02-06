package umc.study.user.infra.http.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import umc.study.user.application.dto.request.UserJoinCommand;
import umc.study.user.infra.http.dto.request.UserJoinDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-06T11:11:55+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.5 (JetBrains s.r.o.)"
)
@Component
public class UserDtoMapperImpl implements UserDtoMapper {

    @Override
    public UserJoinCommand toCommand(UserJoinDto userJoinDto) {
        if ( userJoinDto == null ) {
            return null;
        }

        List<Long> categoryIds = null;
        String name = null;
        String nickname = null;
        String email = null;
        String password = null;
        String phoneNumber = null;
        Integer genderId = null;
        String firstAddress = null;
        String secondAddress = null;
        LocalDateTime birthDate = null;

        List<Long> list = userJoinDto.getCategoryIds();
        if ( list != null ) {
            categoryIds = new ArrayList<Long>( list );
        }
        name = userJoinDto.getName();
        nickname = userJoinDto.getNickname();
        email = userJoinDto.getEmail();
        password = userJoinDto.getPassword();
        phoneNumber = userJoinDto.getPhoneNumber();
        genderId = userJoinDto.getGenderId();
        firstAddress = userJoinDto.getFirstAddress();
        secondAddress = userJoinDto.getSecondAddress();
        birthDate = userJoinDto.getBirthDate();

        UserJoinCommand userJoinCommand = new UserJoinCommand( name, nickname, email, password, phoneNumber, genderId, categoryIds, firstAddress, secondAddress, birthDate );

        return userJoinCommand;
    }
}

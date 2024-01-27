package umc.study.user.application.dto;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;
import umc.study.user.domain.info.Category;
import umc.study.user.domain.User;
import umc.study.user.domain.info.UserPrefer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class UserCommandMapperTest {

    UserCommandMapper mapper = Mappers.getMapper(UserCommandMapper.class);

    @Test
    void toUserPrefersTest() {
        // given
        User testUser = new User("이진", "이복둥", "asda@asdad.com", "lee237"
                , "010-4937-1765", 1, LocalDateTime.now(), "울산", "남구");

        List<Category> testFoodCategories = new ArrayList<>();
        testFoodCategories.add(new Category("패스트푸드"));
        testFoodCategories.add(new Category("중식"));

        // when
        List<UserPrefer> testUserPrefers = mapper.toEntities(testUser, testFoodCategories);

        // then
        assertThat(testUserPrefers.get(0).getUser().getName()).isEqualTo(testUser.getName());
        assertThat(testUserPrefers.get(1).getUser().getName()).isEqualTo(testUser.getName());
        assertThat(testUserPrefers.get(0).getCategory().getName()).isEqualTo("패스트푸드");
        assertThat(testUserPrefers.get(1).getCategory().getName()).isEqualTo("중식");
    }
}

package umc.study.store;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@Slf4j
@SpringBootTest
public class LogicTests {

    @Test
    void 메서드_테스트() {
        LocalDateTime localDateTime1 = LocalDateTime.of(2021, 1, 1, 0, 0, 0);

        log.info(String.valueOf(localDateTime1.isBefore(LocalDateTime.now())));
        log.info(String.valueOf(localDateTime1.isAfter(LocalDateTime.now())));
    }

    @Test
    void 정규표현식_테스트() {
        log.info(String.valueOf(LocalDateTime.now()));
    }
}

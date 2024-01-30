package umc.study.store.domain.location;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class RegionTest {

    @Test
    void extractTown() {

        log.info(Region.extractTown("울산 남구 문수로482"));
    }
}

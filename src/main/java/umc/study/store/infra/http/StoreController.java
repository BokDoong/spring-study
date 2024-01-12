package umc.study.store.infra.http;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class StoreController {
    @GetMapping("/some")
    public int deletePost() {
        return 1;
    }

    @GetMapping("/store")
    public String getStoreInfo(@RequestParam String name) {
        try {
            if (name.equals("가게1")) {
                throw new IllegalStateException("가게 입력 형식이 잘못됐습니다.");
            }
        } catch (IllegalStateException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Store Not Found");
        }
        return null;
    }
}

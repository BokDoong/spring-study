package umc.study.store.infra.http;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import umc.study.store.infra.http.dto.request.StoreRegisterDto;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class StoreController {

//    @GetMapping("/store")
//    public String register(@RequestBody @Valid StoreRegisterDto storeRegisterDto) {
//
//    }
}

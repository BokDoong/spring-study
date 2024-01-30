package umc.study.store.infra.http;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import umc.study.store.application.StoreCommandService;
import umc.study.store.infra.http.dto.StoreDtoMapper;
import umc.study.store.infra.http.dto.request.StoreRegisterDto;

import javax.validation.Valid;

@RequestMapping("/api/v1/stores")
@RequiredArgsConstructor
@RestController
public class StoreController {

    private final StoreCommandService storeCommandService;
    private final StoreDtoMapper storeDtoMapper;

    @PostMapping()
    public String register(@RequestBody @Valid StoreRegisterDto storeRegisterDto) {

        storeCommandService.creatStore(storeDtoMapper.toCommand(storeRegisterDto));
        return "성공";
    }
}

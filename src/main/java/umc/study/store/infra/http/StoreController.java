package umc.study.store.infra.http;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.store.application.StoreCommandService;
import umc.study.store.infra.http.dto.StoreDtoMapper;
import umc.study.store.infra.http.dto.request.ReviewCreateDto;
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

        storeCommandService.create(storeDtoMapper.toCommand(storeRegisterDto));
        return "성공";
    }

    @PostMapping("/{storeId}/reviews")
    public String review(@PathVariable("storeId") long storeId, @RequestBody @Valid ReviewCreateDto reviewCreateDto) {
        storeCommandService.review(1L, storeId, storeDtoMapper.toCommand(reviewCreateDto));
        return "성공";
    }
}

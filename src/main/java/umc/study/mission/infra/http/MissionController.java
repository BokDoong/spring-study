package umc.study.mission.infra.http;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.mission.application.MissionService;
import umc.study.mission.infra.http.dto.request.MissionCreateDto;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @PostMapping()
    public long register(@RequestParam long storeId, @RequestBody @Valid MissionCreateDto missionCreateDto) {
        // 가게에 미션 추가
    }

    @PostMapping("/{missionId}")
    public long challenge(@PathVariable("missionId") long missionId) {
        // 유저 미션 도전
    }
}

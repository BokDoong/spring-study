package umc.study.store.infra.http.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class ReviewCreateDto {
    @NotBlank(message = "리뷰 내용이 없습니다.")
    String content;
    @NotNull(message = "평점이 없습니다.")
    float rating;
}

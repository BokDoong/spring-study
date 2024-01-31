package umc.study.store.infra.http.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class ReviewCreateDto {
    @NotBlank(message = "content is null")
    private String content;
    @NotNull(message = "rating is null")
    private float rating;
}

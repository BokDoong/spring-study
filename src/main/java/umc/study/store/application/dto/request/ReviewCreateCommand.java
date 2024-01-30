package umc.study.store.application.dto.request;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ReviewCreateCommand {
    String content;
    float rating;
}

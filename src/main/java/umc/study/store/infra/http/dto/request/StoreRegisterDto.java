package umc.study.store.infra.http.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import umc.study.common.validator.VerifyNotExistedCategory;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalTime;
import java.util.List;

@Getter
public class StoreRegisterDto {
    @NotBlank(message = "store's name is black")
    String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "kk:mm:ss", timezone = "Asia/Seoul")
    private LocalTime openTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "kk:mm:ss", timezone = "Asia/Seoul")
    private LocalTime closeTime;
    @NotBlank(message = "address is blank")
    @Pattern(regexp = "^[가-힣]+\\s.*구.*$", message = "The address format is not valid")
    private String firstAddress;
    @NotBlank(message = "address is blank")
    private String secondAddress;
    @VerifyNotExistedCategory
    private List<Long> categoryIds;
}

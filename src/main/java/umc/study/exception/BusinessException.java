package umc.study.exception;

import lombok.Getter;
import umc.study.exception.code.ErrorCode;

@Getter
public class BusinessException extends RuntimeException {
    private final ErrorCode errorCode;

    public BusinessException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
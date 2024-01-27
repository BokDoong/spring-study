package umc.study.exception;

import org.aspectj.weaver.ast.Not;
import umc.study.exception.code.ErrorCode;

public class NotFoundException extends BusinessException {
    public NotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }

    public NotFoundException(ErrorCode errorCode, long id) {
        super(errorCode, "id " + id + " is not found");
    }
}

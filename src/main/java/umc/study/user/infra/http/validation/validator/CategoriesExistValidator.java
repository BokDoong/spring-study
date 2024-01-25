package umc.study.user.infra.http.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import umc.study.exception.code.ErrorCode;
import umc.study.user.infra.http.validation.annotation.VerifyNotExistedCategory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoriesExistValidator implements ConstraintValidator<VerifyNotExistedCategory, List<Long>> {
    @Override
    public void initialize(VerifyNotExistedCategory constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    // 실제로 여기서 검증 -> 들어오는 값은 List<Long> 으로 선언.
    @Override
    public boolean isValid(List<Long> requestCategoryIds, ConstraintValidatorContext context) {
        List<Long> categoryIds = new ArrayList<>();
        addIds(categoryIds);

        boolean isValid = requestCategoryIds.stream().allMatch(categoryIds::contains);
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorCode.CATEGORY_NOT_FOUND.getMessage()).addConstraintViolation();
        }

        return isValid;
        //return requestCategoryIds.stream().allMatch(categoryIds::contains);
    }

    private void addIds(List<Long> categoryIds) {
        for (long i = 1; i < 13; i++) {
            categoryIds.add(i);
        }
    }
}

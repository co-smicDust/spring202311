package commons.validators;

import org.springframework.util.StringUtils;

// 필수항목 유효성검사
public interface RequiredValidator {
    default void checkRequired(String str, RuntimeException e) {
        if(!StringUtils.hasText(str)){
            throw e;
        }
    }

    //참이 아닐시 예외 발생
    default void checkTrue(boolean result, RuntimeException e) {
        if(!result){
            throw e;
        }
    }

    //참일 때 예외 발생(false일 때 통과)
    default void checkFalse(boolean result, RuntimeException e) {
        if(result) {
            throw e;
        }
    }
}

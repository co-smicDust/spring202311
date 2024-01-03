package exam01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//메타 어노테이션을 활용, 사용자 정의 어노테이션 선언
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})  //어노테이션 적용 대상 설정
@Retention(RetentionPolicy.RUNTIME) //런타임 시까지 어노테이션 사용
public @interface MyAnno {
    //추상메서드 정의 -> 설정
    String value(); //추가 정보 전달 설정
}

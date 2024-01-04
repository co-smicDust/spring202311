package config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect //공통 기능이 포함된 클래스(프록시로 사용할 클래스)
@Order(1)
public class ProxyCalculator {
    //@Pointcut("execution(* aopex..*(..))")  //공통 기능이 적용될 범위(단순 정보 전달)
    /*
    - execution 명시자: Advice를 적용할 메서드 지정시 사용.
        => execution(수식어패턴(생략가능.public,..) 리턴타입패턴 클래스명패턴.메서드명패턴(매개변수패턴))
    - 첫번째 *: 모든 반환값
    - aopex.*: aopex 패키지의 모든 하위 클래스 ex)aopex.Calculator
    - aopex..*: aopex 패키지를 포함한 하위 패키지 전체 모든 클래스 ex)aopex.sub.sub2.Calculator
    - 두번째 *: 클래스명과 메서드명을 포함한 전체
    - (..): 메서드 매개변수에 대한 패턴
        (..): 0개 이상의 매개변수 패턴 - 모든 메서드
        (*,*): 2개의 매개변수를 가진 매개변수 패턴
        (long): 매개변수가 1개 있고 자료형이 long인 패턴
        (long, *): 매개변수가 2개, 첫번째는 long으로 고정
        (long, ..): 첫번째는 long으로 고정, 나머지는 있어도 되고 없어도 되는 패턴
     */
    //public void publicTarget(){}

    //@Around("publicTarget()")   //공통 기능을 수행하고 핵심 기능을 대신 수행해 주는 메서드
    @Around("config.CommonPointcut.publicTarget()")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable{
        //현재 호출하고 있는 핵심기능의 메서드에 대한 정보 반환
        //Signature sig = joinPoint.getSignature();
        //System.out.println(sig.toLongString());

        Object[] args = joinPoint.getArgs();
        long num = (Long)args[0];
        System.out.println(num);

        long stime = System.nanoTime(); //공통 기능

        try{
            Object result = joinPoint.proceed(); //핵심 기능을 대신 수행하는 메서드
                //factorial(...)
            return result;
        } finally {
            long etime = System.nanoTime(); //공통 기능
            System.out.printf("걸린시간: %d%n", etime - stime);
        }
    }
}

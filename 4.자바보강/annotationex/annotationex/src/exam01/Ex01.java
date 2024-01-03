package exam01;

//어노테이션 값을 사용하기 위한 클래스 생성
@MyAnno(value = "값")    //추가 값 넣어주기
public class Ex01 {
    @MyAnno
    int num;
    @MyAnno
    void method(){

    }
}

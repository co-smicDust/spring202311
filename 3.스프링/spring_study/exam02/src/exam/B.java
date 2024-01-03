package exam;

public class B extends A {
    int numB = 20;

    public B(){
        // super: 지역 변수 : 상위 클래스 객체의 참조 변수
        super(); // 상위 클래스 생성자 메서드 => A()
        System.out.println("B 생성자!");
    }
}

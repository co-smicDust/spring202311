package exam03;

public class Bird extends Animal {
    @Override
    public void move() {
        System.out.println("두 날개로 날아간다.");
    }

    public void readBook() {
        System.out.println("독서를 한다.");
    }
}

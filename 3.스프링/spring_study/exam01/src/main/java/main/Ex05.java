package main;

public class Ex05 {
    public static void main(String[] args) {
        try {
            int num1 = 10;
            int num2 = 0;
            int result = num1 / num2;    //throw new ArithmeticException();
        } catch (ArithmeticException e) {   //new ArithmeticException();
            //e.printStackTrace();
            System.out.println("예외 처리...");
        }
        System.out.println("매우 중요한 실행 코드..");

    }
}

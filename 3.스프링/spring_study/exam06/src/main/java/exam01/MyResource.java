package exam01;

//자원해제가 필요한 자원이라고 가정
public class MyResource implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("자원 해제...");
    }
}

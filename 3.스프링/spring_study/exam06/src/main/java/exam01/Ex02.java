package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex02 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "SPRING6";
        String password = "_aA123456";

        //@TrywithResources: 자원해제를 자동으로 해주는 try~catch
        //try(해제할 자원 객체; 해제할 자원 객체 ...) {} catch(예외 객체 ...) {}
        //finally가 없어도 잘 동작함
        //자원이 더 있을 때는 ;를 입력 후 계속 입력
        //해제할 자원이 AutoCloseable 인터페이스의 구현체만 가능

        //4. 쿼리문 실행 - Statement/PreparedStatement/CallableStatement 객체 생성
        //  1) Statement - Connection.createStatement();
        //     : 정적 쿼리에 사용. 하나의 쿼리를 사용하고 나면 더는 사용 불가. Statement 객체의 메서드 종류
        //     ResultSet executeQuery(String sql)
        //     : 조회용 쿼리(SELECT...). 반환값 ResultSet - 레코드를 조회할 수 있는 커서
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()){

            String sql = "INSERT INTO MEMBER (USER_NO, USER_ID, USER_PW, USER_NM, EMAIL) "
                    + " VALUES (SEQ_MEMBER.nextval, 'USER01', '123456', '사용자01', 'user01@text.org')";
            // int executeUpdate(String sql)
            // : 데이터 변경용 쿼리(INSERT, UPDATE, DELETE). 반환값 - 반영된 레코드 갯수
            int result = stmt.executeUpdate(sql);
            System.out.println(result);

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}

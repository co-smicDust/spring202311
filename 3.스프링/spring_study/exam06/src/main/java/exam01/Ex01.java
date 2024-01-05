package exam01;

//JDBC로 데이터베이스 연동하기
//1. java.sql.* 패키지 import
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex01 {
    //2. JDBC 드라이버 로딩
    //  - ojdvc11.jar
    //  - Class.forName("패키지명을 포함한 클래스명");
    //   : 클래스파일을 메모리에 올림(모든 클래스는 메모리에 올라가야 사용 가능)
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        //3. 데이터베이스 접속을 위한 Connection 객체 생성
        //  * localhost: 같은 서버 위치, 127.0.0.1: IP(자리수 각각 1byte), 1521: 포트.데이터 이동 통로.
        // - DriverManager
        //  .getConnection(String URL)
        //  .getConnection(String URL, String user, String password)
        //  .getConnection(String URL, Properties prop)

        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "SPRING6";
        String password = "_aA123456";

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println(conn);

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            if(conn != null) {
                try{
                    conn.close();
                } catch (SQLException e2){}
            }
        }
    }
}

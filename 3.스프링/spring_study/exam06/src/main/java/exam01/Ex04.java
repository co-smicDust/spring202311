package exam01;

import java.sql.*;

public class Ex04 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "SPRING6";
        String password = "_aA123456";

        String sql = "INSERT INTO MEMBER (USER_NO, USER_ID, USER_PW, USER_NM, EMAIL)"
                     + " VALUES (SEQ_MEMBER.nextval, ?, ?, ?, ?)";

        /*
             2) PreparedStatement - Connection.prepareStatement(String sql);
              : 동적인 쿼리에 사용. PreparedStatement 객체는 하나의 객체로 여러 번의 쿼리 실행 가능.
                동일한 쿼리문을 특정 값만 변경하여 여러 번 실행해야 할 때, 매개변수가 많아 쿼리문을 정리해야 할 때 유용.
                setXxx() 메서드
                PreparedStatement 객체의 메서드 - ResultSet rs executeQuery(); int executeUpdate();
         */
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"USER_NO"})){
            pstmt.setString(1,"USER05");
            pstmt.setString(2,"123456");
            pstmt.setString(3,"사용자05");
            pstmt.setString(4,"user02@text.org");

            int result = pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if(rs.next()){
                long userNo = rs.getLong(1);
                System.out.printf("USER_NO : %d%n", userNo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

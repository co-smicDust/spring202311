package exam01;

import java.sql.*;
import java.time.LocalDateTime;

public class Ex05 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "SPRING6";
        String password = "_aA123456";

        String sql = "SELECT * FROM MEMBER";

        /*
        5. 쿼리문 실행 결과 값 가져오기
          1) ResultSet
              getDate(...): 날짜 java.sql.Date
              getTime(...): 시간 java.sql.Time
              getTimestamp(...): 날짜&시간 java.sql.Timestamp
         */
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while(rs.next()){
                long userNo = rs.getLong("USER_NO");
                String userId = rs.getString("USER_ID");
                String userNm = rs.getString("USER_NM");
                LocalDateTime regDt = rs.getTimestamp("REG_DT").toLocalDateTime();

                System.out.printf("userNo=%d, userId=%s, userNm=%s, regDt=%s%n",
                        userNo, userId, userNm, regDt);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}

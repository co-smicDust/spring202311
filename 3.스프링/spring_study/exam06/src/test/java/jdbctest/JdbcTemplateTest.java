package jdbctest;

//Spring 프레임워크의 JUnit5 확장 기능을 사용하여 데이터베이스 연결을 테스트하는 코드

import config.AppCtx;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Connection;
import java.sql.SQLException;

@ExtendWith(SpringExtension.class)              //JUnit5 확장 모델을 사용하여 Spring 테스트 컨텍스트와 통합
@ContextConfiguration(classes = AppCtx.class)   //테스트 컨텍스트를 설정
public class JdbcTemplateTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test   //JUnit에서 테스트 메서드를 나타내는 애노테이션
    @DisplayName("DataSource를 통한 DB연결 테스트") //테스트 클래스 또는 테스트 메서드의 이름을 사람이 읽기 쉬운 형태로 지정
    void connectionTest(){
        try(Connection conn = dataSource.getConnection()){
            System.out.println(conn);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("INSERT 테스트")
    void insertTest(){
        // DataAccessException - RuntimeException - 예외처리 X -> 실행

        String sql = "INSERT INTO MEMBER (USER_NO, USER_ID, USER_PW, USER_NM, EMAIL) " +
                " VALUES (SEQ_MEMBER.nextval, ?, ?, ?, ?)";
        int affectedRows = jdbcTemplate.update(sql,
                "USER99", "123456", "사용자99", "user99@test.org");

        System.out.println(affectedRows);
    }
}

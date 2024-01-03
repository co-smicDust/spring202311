package config;

import models.member.JoinService;
import models.member.JoinValidator;
import models.member.ListService;
import models.member.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//기본생성자만 정의되어있는 설정 클래스(필요한 매개변수들은 autowired로 자동으로 의존성 주입)
@Configuration
@Import(value = {AppCtx3.class})
//value가 하나일 경우 다음과 같이 써도 됨
//@Import({AppCtx3.class})
//@import(AppCtx3.class)
public class AppCtx2 {
    @Bean
    public JoinValidator joinValidator(){
        return new JoinValidator();
    }
    @Bean
    public JoinService joinService(){
        return new JoinService();
    }
    @Bean
    public ListService listService(){
        return new ListService();
    }
}

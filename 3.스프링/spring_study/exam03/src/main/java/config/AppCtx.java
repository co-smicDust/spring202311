package config;

import models.member.JoinService;
import models.member.JoinValidator;
import models.member.ListService;
import models.member.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//의존성 직접 주입
//@Configuration: 설정 클래스임을 알림
@Configuration
public class AppCtx {
    //@Bean: 스프링이 관리하는 객체임을 알림
    @Bean
    public MemberDao memberDao(){
        return new MemberDao();
    }

    //JoinValidator는 MemberDao에 의존
    @Bean
    public JoinValidator joinValidator(){
        return new JoinValidator(memberDao());
    }

    //두가지에 의존(memberDao, joinValidator)
    @Bean
    public JoinService joinService(){
        return new JoinService(memberDao(), joinValidator());
    }

    @Bean
    public ListService listService(){
        ListService listService = new ListService();
        listService.setMemberDao(memberDao());

        return listService;
    }
}

package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class JoinService {
    //JoinService는 MemberDao와 JoinValidator에 의존 중
    //그러나 AppCtx2에서 JoinService의 기본생성자만 만들어 줌
    //=>스프링에게 자동 주입해달라고 맡김
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private JoinValidator validator;
    //기본 생성자 추가(의존성을 직접 주입하지 않고 자동주입하기 위해 - @Autowired 사용)
    public JoinService(){}

    //생성자를 이용한 의존성 주입 방법
    public JoinService(MemberDao memberDao, JoinValidator validator){
        this.memberDao = memberDao;
        this.validator = validator;
    }

    public void join(Member member){
        //데이터 검증
        validator.validate(member);

        //데이터 추가
        memberDao.register(member);
    }
}

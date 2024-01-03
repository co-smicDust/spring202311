package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

//회원목록 출력
@Service
public class ListService {
    private MemberDao memberDao;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy.MM.dd");

    //의존성 자동 주입 - 호출되면서 필요한 자원 투입
    //@Autowired(required = false)
    @Autowired
    public void setFormatter(@Nullable DateTimeFormatter formatter){
        this.formatter = formatter;
    }

    //setMemberDao 메서드를 호출한 후 매개변수로 MemberDao가 필요한 것을 보고 MemberDao를 가져옴
    //setter 통해 주입
    @Autowired
    public void setMemberDao(MemberDao memberDao){

        this.memberDao = memberDao;
    }
    public void print(){
        List<Member> members = memberDao.getList();
        for(Member member : members){
            if(formatter != null) {
                String regDtStr = formatter.format(member.getRegDt());
                member.setRegDtStr(regDtStr);
            }
            System.out.println(member);
        }
    }
}

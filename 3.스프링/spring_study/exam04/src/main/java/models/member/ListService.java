package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//회원목록 출력
@Service
public class ListService {
    private MemberDao memberDao;

    //setter 통해 주입
    @Autowired
    public void setMemberDao(MemberDao memberDao){
        this.memberDao = memberDao;
    }
    public void print(){
        List<Member> members = memberDao.getList();
        for(Member member : members){
            System.out.println(member);
        }
    }
}

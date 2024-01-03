package main;

import models.member.*;

import javax.sql.rowset.Joinable;
import java.time.LocalDateTime;

public class Ex06 {
    public static void main(String[] args) {
        /*
        MemberDao memberDao = new MemberDao();
        JoinValidator joinValidator = new JoinValidator(memberDao);
        JoinService joinService = new JoinService(memberDao, joinValidator);

        ListService listService = new ListService();
        listService.setMemberDao(memberDao);
        */

        //최초 한번만 객체 생성, 완성된 객체를 가져옴(주입 필요 X)
        JoinService joinService = ServiceManager.getInstance().joinService();
        ListService listService = ServiceManager.getInstance().listService();

        Member member = new Member();
        member.setUserId("user01");
        member.setUserPw("123456");
        member.setConfirmPw("123456");
        member.setUserNm("사용자01");
        member.setRegDt(LocalDateTime.now());

        joinService.join(member); //가입

        listService.print(); //목록 출력
    }
}

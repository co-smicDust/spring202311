package models.member;

import commons.exceptions.BadRequestException;
import commons.validators.RequiredValidator;
import commons.validators.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class JoinValidator implements Validator<Member>, RequiredValidator {
    @Autowired
    private MemberDao memberDao; //변수선언(회원정보저장)

    //기본 생성자 추가(의존자동주입을 위해)
    public JoinValidator(){}
    public JoinValidator(MemberDao memberDao){
        this.memberDao = memberDao;
    }

    //전달받은 데이터를 검증 (ex. 필수항목 - id/pw 입력조건 등..)
    public void validate(Member member) {
        //필수항목 검증(아이디, 비밀번호, 비밀번호 확인, 회원명)
        String userId = member.getUserId();
        String userPw = member.getUserPw();
        String confirmPw = member.getConfirmPw();
        String userNm = member.getUserNm();


        //RequiredValidator 인터페이스를 이용하여 유효성 검사
        //checkRequired(String str, RuntimeException e) 이므로
        //매개변수에 RuntimeException 대신 상속받은 BadRequestException을 삽입
        checkRequired(userId, new BadRequestException("아이디를 입력하세요."));
        checkRequired(userPw, new BadRequestException("비밀번호를 입력하세요."));
        checkRequired(confirmPw, new BadRequestException("비밀번호를 확인하세요."));
        checkRequired(userNm, new BadRequestException("회원명을 입력하세요."));

        //아이디가 이미 등록되어 있는지 체크
        checkFalse(memberDao.exists(userId), new BadRequestException("이미 등록된 아이디입니다."));

        //비밀번호, 비밀번호 확인시 일치 여부
        checkTrue(userPw.equals(confirmPw), new BadRequestException("비밀번호가 일치하지 않습니다."));
    }
}

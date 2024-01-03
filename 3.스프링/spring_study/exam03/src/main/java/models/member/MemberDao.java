package models.member;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemberDao {
    //데이터 저장소
    //해시맵 - 키: 회원ID, 값: 회원 객체
    private static Map<String, Member> members = new HashMap<>();
    //회원등록 메서드
    public void register(Member member){
        //put: 새로운 요소 추가
        members.put(member.getUserId(), member);
    }

    //회원정보가 이미 존재하니? (이미 등록된 회원이니?)
    public boolean exists(String userId) {
        //boolean 값 반환 (주어진 키가 맵에 존재하는가? = ID가 이미 존재?)
        return members.containsKey(userId);
    }

    //현재 등록된 모든 회원 목록 반환
    public List<Member> getList(){
        //members 맵의 값들을 새로운 ArrayList에 복사하여 반환
        //맵의 변경에 따라 원본 데이터에 영향을 주지 않으면서 목록을 제공
        return new ArrayList<>(members.values());
    }
}

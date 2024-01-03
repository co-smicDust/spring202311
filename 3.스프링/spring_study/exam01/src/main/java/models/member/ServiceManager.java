package models.member;

//객체조립기 역할
public class ServiceManager {
    //싱글톤은 최초에 한번 생성, 한번 생성되어 있으면 그때부턴 만들어진 객체 공유

    //instance는 ServiceManager 클래스의 유일한 인스턴스를 저장하는 정적 변수
    private static ServiceManager instance = null;
    //외부에서 객체를 생성할 수 없도록 생성자에 private 선언
    private ServiceManager(){}

    //<싱글톤 패턴 구현>
    //instance가 null이면 최초로 객체를 만들고 객체가 존재하면(!null) 그 후부터는 만들지 않고 이미 만들어진 객체 사용
    //객체를 외부에서 만들지 못하기 때문에 static을 붙여서 정적 메서드로 만듦
    public static ServiceManager getInstance(){
        if(instance == null){
            instance = new ServiceManager();
        }
        return instance;
    }

    public MemberDao memberDao() {
        return new CachedMemberDao();
    }

    public JoinValidator joinValidator(){
        //memberDao의 인스턴스를 얻어와서 사용 / 완성된 객체형태로 가져오게 됨
        return new JoinValidator(memberDao());
    }
    public JoinService joinService(){
        //완성된 객체형태로 가져오게 됨
        return new JoinService(memberDao(), joinValidator());
    }

    public ListService listService(){
        ListService listService = new ListService();
        listService.setMemberDao(memberDao());

        return listService;
    }
}

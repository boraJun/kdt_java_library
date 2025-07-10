package library02;
import java.util.HashMap;
import java.util.Map;

public class LoginManager {
	/**
	 * @see user 정보 컬렉션, key : 사용자 id, value : User 객체
	 */
	private Map<String, User> userMap;
	
	//생성자
	public LoginManager() { 
		userMap = new HashMap<>();
	}
	
	/**
	 * @see 회원가입
	 * @param id : 사용자 id
	 * @param password : 사용자 password
	 * @param name : 사용자 이름
	 * @return 이미 id 가 존재하면 false, 추가 완료하면 true 반환
	 * @author jbr
	 */
	public boolean addMember(String id, String password, String name) {
		if(userMap.containsKey(id)) { // 회원가입
			return false;
		}

		userMap.put(id, new Member(id, password, name));
		return true;
	}
	
	/**
	 * @see 사용자 조회
	 * @param id : 사용자 id
	 * @param password : 사용자 password
	 * @param name : 사용자 이름
	 * @return id가 존재하면 User 객체 반환, 존재하지 않으면 null 반환
	 * @author jbr
	 * 
	 */
	public User getUser(String id) {
		if(userMap.containsKey(id)) {
			return userMap.get(id);
		}
		
		return null;
	}
	
	/**
	 * @see 로그인
	 * @param id : 사용자 id
	 * @param password : 사용자 password
	 * @return id 와 password 둘 중 하나 이상 틀렸을 경우 false, 로그인 성공 시 true
	 * @author jbr
	 */
	public boolean login(String id, String password) {
		if(userMap.containsKey(id)) {
			return userMap.get(id).login(id, password);
		}
		
		return false;
	}
}

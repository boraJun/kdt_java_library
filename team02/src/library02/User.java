package library02;

public abstract class User {
	//사용자 기본정보 필드
		private String id;
		private String password;
		private String name;
		
		abstract boolean login(String id, String pw);
		
		
}

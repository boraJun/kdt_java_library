package library02;

public abstract class User {
		//사용자 기본정보 필드
		private static int currentUserIndex = 0;	//전체 사용자 번호 순서
		
		private String id;				//id
		private String password;		//password
		private String name;			//name
		private int userIndex;			//사용자 번호
		
		//생성자(id, password, name)
		public User(String id, String password, String name) {
			this.id = id;
			this.password = password;
			this.name = name;
			
			userIndex = currentUserIndex++;
		}
		
		//getter
		public String getId() {
			return id;
		}

		protected String getPassword() {
			return password;
		}

		public String getName() {
			return name;
		}

		//추상메소드 
		//로그인
		public abstract boolean login(String id, String pw);

		//Object 클래스 메소드 오버라이딩
		@Override
		public int hashCode() {
			return userIndex;
		}

		@Override
		public boolean equals(Object obj) {
			//id 와 userIndex가 같은 User 를 같은 User 로 판단
			if(obj instanceof User) {
				if(!((User) obj).getId().equals(this.id)) {
					return false;
				}
			}
			
			return this.hashCode() == obj.hashCode();
		}
		
		@Override
		public String toString() {
			return "id : " + this.id + ", name :" + this.name;
		}
		
}

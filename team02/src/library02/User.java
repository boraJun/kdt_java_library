package library02;

public abstract class User {
	//사용자 기본정보 필드
		private static int currentUserIndex = 0;
		private String id;
		private String password;
		private String name;
		private int userIndex;
		
		public User(String id, String password, String name) {
			this.id = id;
			this.password = password;
			this.name = name;
			
			userIndex = currentUserIndex++;
		}
		
		//getter 와 setter
		public String getId() {
			return id;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public abstract boolean login(String id, String pw);

		@Override
		public int hashCode() {
			return userIndex;
		}

		@Override
		public boolean equals(Object obj) {
			if(obj instanceof User) {
				if(!((User) obj).getId().equals(this.id)) {
					return false;
				}
			}
			
			return this.hashCode() != obj.hashCode();
		}

		@Override
		public String toString() {
			return this.id;
		}
}

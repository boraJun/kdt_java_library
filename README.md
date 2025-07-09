1번 보라	사용자 설계자	User, LoginManager	User 추상클래스 설계
						사용자 기본정보
						LoginManager 클래스 설계
						(Map에 사용자 저장/조회)
						사용자 로그인 기능 구현

2번 버들	회원 기능 담당	Memeber			User 클래스 상속
						List 필드
						로그인 메소드 오버라이딩
						도서 대출 메소드 //이미 대출, 최대 권수, 대출 가능
						도서 반납 메소드
						대출 중인 책 목록 확인 메소드


3번 용문	도서 설계자	Book, Borrow 인터페이스	Borrow 인터페이스
						추상 메소드 2개(대여 -> 예외 던지기, 반납)
						Book 클래스 설계
						도서와 관련된 기본 정보 // 이름, 저자, 도서수
						도서 대출 메소드 오버라이딩
						equals, hashCode 오버라이딩

4번 기수	서비스 로직 설계자	LibraryService		리스트 인터페이스 객체
						도서목록 출력
						도서 검색 메소드
						도서 대여 메소드(매개변수 2개 = Member, 도서제목)
						도서 반납 메소드(매개변수 2개 = Member, 도서제목)

5번 x	예외클래스		MaxBorrowException		사용자 정의 예외 클래스
			BookNotAvailableException 	//빌릴수없을때
			BookAlreayException		

6번 건아	UI 및 실행	ConsoleUI, LibraryApp	ConsoleUI 클래스
                  				번호로 입력(Scanner 입력)
                  				메뉴 메소드
                  				대출할 책 목록 메소드
                  				반납할 책 목록 메소드

                  				LibraryApp 클래스
                  				main메소드

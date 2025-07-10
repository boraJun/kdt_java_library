package library02;

import java.util.ArrayList;
import java.util.List;

//기수 LibraryService
public class LibraryService {

	// 필드
//리스트<Borrow> = <Book>//업캐스팅
	private List<Borrow> bookList;

//기본생성자   
	public LibraryService() { // 생성자에서 도서목록 추가 
		super();
		bookList = new ArrayList<Borrow>();
		initBookList();
	}

	// 도서목록 생성 메소드
	private void initBookList() {// 도서목록을 하나하나추가해줬구여 이름이 다달라서 안타깝게도 하나하나 직접 입력했습니다 ^^
		addBook("자바의 정석", "전보라");
		addBook("해리포터", "김기수");
		addBook("어린왕자", "김용문");
		addBook("라이언 일병 구하기", "이남혁");
		addBook("연애혁명", "박건아");
		addBook("마음에도 근육이 붙나봐요", "강버들");
		addBook("자바가 제일 쉬웠어요", "김영선");
	}

	private void addBook(String bookName, String writer) { //addbook 메소드입니다 매개변수 스트링타입 북네임 롸이터 넣어줬구요
		try { // 예외처리 위해서 트케 써줬구요
			for (Borrow book : bookList) { // 북리스트 리스트를 for-each 문 돌려주구요
				if (book instanceof Book) { //book이 Book타입이면
					if (((Book) book).getName().equals(bookName)) { //북리스트에있는 책이름이랑 등록할 책이랑 같다면
						throw new BookAlreayException("이미 존재하는 책입니다."); //예외처리 객체 생성
					}
				}
			}
		} catch (BookAlreayException e) { //트케에서 캐치구여 
			System.out.println(e.getMessage()); // 예외처리메시지 출력
			return; //리턴
		}

		bookList.add(new Book(bookName, writer)); // 예외처리 안걸린 경우구요 그니까 북리스트랑 추가할 책이름이 다른거죠 그러면 뭐해야한다 ? 추가할 수있따
	}

//도서목록 출력 메소드
//List<String> getBookList()
	public List<String> getBookList() { // 도서정보리스트를 반환해주는 고런 메소드입니다
		List<String> bl = new ArrayList<>();// 리스트 b1 생성
		for (Borrow b : bookList) { // 북리스트를 for-each 문으로 돌리기
			if (b instanceof Book) { // b 가 Book타입인지 확인
				bl.add(((Book) b).toString()); // Book타입이 맞으면 b1에 b의 정보를 추가
			}
		}
		return bl; // 추가된 정보리스트를 바놘
	}

//도서 검색 메소드
	public Book searchBook(String bookName) { // 도서 검색 메소드 입니다 매개변수로 받는 책이름이 필드 북리스트에 같은 이름이 존재하는지 보는 메소드입니다
		if (bookList == null) // 북리스트에 아무것도 없으면
			return null;// 리턴 널
		for (Borrow b : bookList) { // 북리스트를 for-each 문으로 돌리기
			if (b instanceof Book) { // Book 타입인데
				if (((Book) b).getName().equals(bookName)) { // 이름이같으면
					return (Book) b; // b를 반환 b 는 북리스에 있는 값중 하나임 ㅋ
				}
			}
		}

		return null;// 같은이름이 없으면 리턴 널
	}

//boolean 대여(Member, 도서제목) throws 대출여부에따라 예외처리; 
//   book -> 대여 호출
//   member -> 대여 호출
	public boolean rentalBook(Member m, String bookName) throws MaxBorrowException, BookNotAvailableException {
//		렌탈북 메소드입니다 멤버타입 m, String타입 북네임을 매개변수로 넣음, 예외던지기 했음
		if (m == null) //사용자정보가 널이면
			return false; //뻘스
		if (this.searchBook(bookName).borrowBook()) { // 책을 대여 가능하면

			m.borrowingBook(bookName);// 사용자 대출리스트에 추가
			return true; //트루 반환
		}

		return false; // 뻘스 반환
	}

//boolean 반납(Member, 도서제목) book -> 반납 호출
//   book ->  반납 호출
//   member -> 반납 호출
	public boolean returnBook(Member m, String bookName) { //반납메소드입니다 멤버타입 m, String타입 북네임을 매개변수로 넣음
		if (m.returningBook(bookName)) { //사용자 책반납 가능하면
			this.searchBook(bookName).returnBook(); // 북네임이랑 같은 북을 받아서 책반납을 한다
			return true;// 트루 반환
		}

		return false; //뻘스 반환
	}

}

package library02;

import java.util.ArrayList;
import java.util.List;

//기수 LibraryService
public class LibraryService {
//리스트<Borrow> = <Book>//업캐스팅
	private List<Borrow> libraryService;
//List<String> getBookList()
	private List<String> getBookList;

//기본생성자   
public LibraryService(List<Borrow> libraryService, List<String> getBookList) {
	super();
	libraryService = new ArrayList<Borrow>();// 상속하면 Borrow -> Book 으로 바꿔
	this.libraryService = libraryService;
	this.getBookList = getBookList;
}

//도서목록 출력 메소드
	
//도서 검색 메소드
	
	
	
//boolean 대여(Member, 도서제목) throws 대출여부에따라 예외처리; 
//   book -> 대여 호출
//   member -> 대여 호출
	public boolean rentalBook(Member, ) throws Exception{
//		멤버 -> 19개 미만이면 대여가능 20개 이상이면 대여 불가능
//		책 -> fasle 면 대여가능 true면 대여 불가능
//		Member(name)
		
		return;
	}
	
//boolean 반납(Member, 도서제목) book -> 반납 호출
//   book -> > 반납 호출
//   member -> 반납 호출
	public boolean returnBook(Member, ) {
//		흠
		
		
		return;
	}
	
}

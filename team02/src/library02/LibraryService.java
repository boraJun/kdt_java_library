package library02;

import java.util.ArrayList;
import java.util.List;

//기수 LibraryService
public class LibraryService {
//리스트<Borrow> = <Book>//업캐스팅
	private List<Book> bookList;

//기본생성자   
public LibraryService(List<Book> libraryService) {
	super();
	bookList = new ArrayList<Book>();// 상속하면 Borrow -> Book 으로 바꿔
	this.bookList = libraryService;
}

//도서목록 출력 메소드
//List<String> getBookList()
	public List<String> getBookList(){
		List<String> bl = new  ArrayList<>();
		for(Book b : bookList) {
			bl.add(b.getName());
			
		}
		return bl;
	}
	
//도서 검색 메소드
	public boolean searchBook(String bookname) {
		if(bookList == null)
			return false;
		
		for(Book b : bookList) {
			//if(b.getName().equals(bookName))
				return true;
		}
		
		return false;
	}
	
	
//boolean 대여(Member, 도서제목) throws 대출여부에따라 예외처리; 
//   book -> 대여 호출
//   member -> 대여 호출
	public boolean rentalBook(Member, ) throws Exception{
//		멤버 -> 19개 미만이면 대여가능 20개 이상이면 대여 불가능 맥스바로우
//		if(Member(책빌린개수)<19) {
//			대여가능
//		}else {
//			대여불가능
//		}
//		책 -> fasle 면 대여가능 true면 대여 불가능 북 낫 어베일러블
//		Member(name)
//		if(Member(name) = false) {
//			대여가능
//		}else {
//			대여불가능
//		}
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

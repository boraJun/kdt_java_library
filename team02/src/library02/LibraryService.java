package library02;

import java.util.ArrayList;
import java.util.List;

//기수 LibraryService
public class LibraryService {
//리스트<Borrow> = <Book>//업캐스팅
	private List<Borrow> bookList;

//기본생성자   
	public LibraryService(List<Borrow> bookList) {
		super();
		this.bookList = new ArrayList<Borrow>();// 상속하면 Borrow -> Book 으로 바꿔
		this.bookList = bookList;
	}

//도서목록 출력 메소드
//List<String> getBookList()
	public List<String> getBookList() {
		List<String> bl = new ArrayList<>();
		for (Borrow b : bookList) {
			if (b instanceof Book) {
				bl.add(((Book) b).getName());
			}
		}
		return bl;
	}

//도서 검색 메소드
	public Book searchBook(String bookName) {
		if (bookList == null)
			return null;

		for (Borrow b : bookList) {
			if (b instanceof Book) {

				if (((Book) b).getName().equals(bookName))

					return (Book) b;
			}
		}

		return null;
	}

//boolean 대여(Member, 도서제목) throws 대출여부에따라 예외처리; 
//   book -> 대여 호출
//   member -> 대여 호출
	public boolean rentalBook(Member m, String bookName) throws MaxBorrowException, BookNotAvailableException {
		if (this.searchBook(bookName).borrowBook()) {
			m.borrowingBook(bookName);
			return true;
		}

		return false;
	}

//boolean 반납(Member, 도서제목) book -> 반납 호출
//   book -> > 반납 호출
//   member -> 반납 호출
	public boolean returnBook(Member m, String bookName) {
		if (m.returningBook(bookName)) {
			this.searchBook(bookName).returnBook();
			return true;
		}

		return false;
	}

}

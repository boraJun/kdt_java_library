package library02;

import java.util.ArrayList;
import java.util.List;

//기수 LibraryService
public class LibraryService {
//리스트<Borrow> = <Book>//업캐스팅
	private List<Borrow> bookList;
	static final int MAX_BOOK_COUNT = 5;

//기본생성자   
	public LibraryService() {
		super();
		bookList = new ArrayList<Borrow>();

		initBookList();
	}

	// 도서목록 생성 메소드
	private void initBookList() {
		addBook("자바의 정석1", "김영수");
		addBook("자바의 정석2", "김영수");
		addBook("자바의 정석2", "짱구");
		addBook("자바의 정석3", "김영수");
		addBook("자바의 정석3", "김영수");
		addBook("자바의 정석4", "김영수");
		addBook("자바의 정석5", "김영수");
	}

	private void addBook(String bookName, String writer) {
		try {
			for (Borrow book : bookList) {
				if (book instanceof Book) {
					if (((Book) book).getName().equals(bookName) && ((Book) book).getWriter().equals(writer)) {
						throw new BookAlreayException("이미 존재하는 책입니다.");
					}
				}
			}
		} catch (BookAlreayException e) {
			System.out.println(e.getMessage());
			return;
		}

		bookList.add(new Book(bookName, writer));
	}

//도서목록 출력 메소드
//List<String> getBookList()
	public List<String> getBookList() {
		List<String> bl = new ArrayList<>();// 객체 생성 업캐스팅임
		for (Borrow b : bookList) {
			if (b instanceof Book) {
				bl.add(((Book) b).toString());
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
				if (((Book) b).getName().equals(bookName)) {
					return (Book) b;
				}
			}
		}

		return null;
	}

//boolean 대여(Member, 도서제목) throws 대출여부에따라 예외처리; 
//   book -> 대여 호출
//   member -> 대여 호출
	public boolean rentalBook(Member m, String bookName) throws MaxBorrowException, BookNotAvailableException {
		if (this.searchBook(bookName).borrowBook()) {
			if (m != null)
				m.borrowingBook(bookName);
			return true;
		}

		return false;
	}

//boolean 반납(Member, 도서제목) book -> 반납 호출
//   book ->  반납 호출
//   member -> 반납 호출
	public boolean returnBook(Member m, String bookName) {
		if (m.returningBook(bookName)) {
			this.searchBook(bookName).returnBook();
			return true;
		}

		return false;
	}

}

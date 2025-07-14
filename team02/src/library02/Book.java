package library02;

public class Book implements Borrow {

	private String bookName;
	private String writer;
	private boolean isBorrowed;
	private int bookhash;

	/**
	 * @see Book클래스 생성자
	 * @param bookName : 책 이름
	 * @param writer : 책 저자
	 * @author kym
	 */
	public Book(String bookName, String writer) {
		this.bookName = bookName;
		this.writer = writer;
		this.bookhash = bookName.hashCode();
	}

	/**
	 * @see 책이름 getter
	 * @return : 책 이름 리턴
	 * @author kym
	 */
	public String getName() {
		return bookName;
	}

	/**
	 * @see 책 저자 getter
	 * @return : 책 저자 리턴
	 * @author kym
	 */
	public String getWriter() {
		return writer;
	}

	/**
	 * @see 책 대여 가능여부 확인
	 * @return isBorrowed가 false이면 대여 가능하며 true로 값 변경 후 리턴
	 * @throws BookNotAvailableException 예외 강제발생시킨 후 예외 던지기
	 * @author kym
	 */
	@Override
	public boolean borrowBook() throws BookNotAvailableException {
		if (isBorrowed == true) {
			throw new BookNotAvailableException("다른 고객님이 대여중입니다.");
		} else {
			this.isBorrowed = true;
			return this.isBorrowed;
		}
	}
	
	/**
	 * @see 책 반납 메소드
	 * @return 메소드 호출 시 이 객체의 isBorrowed 값을 false로 변경<br>false로 변경된 값을 반환
	 * @author kym
	 */
	@Override
	public boolean returnBook() {
		this.isBorrowed = false;
		return this.isBorrowed;
	}

	/**
	 * @see 해시코드 반환
	 * @return 이 책의 이름을 해시코드로 변환시킨 값을 반환
	 * @author kym
	 */
	@Override
	public int hashCode() {
		return this.bookhash;
	}

	/**
	 * @see 동일여부 판단
	 * @param obj : 호출 시 인수로 넘긴 객체 정보
	 * <p> 매개변수로 받은 객체가 Book클래스 타입이고,
	 * <br> 이 객체를 Book 타입으로 다운캐스팅해 책 이름의 해시코드값이
	 * <br> bookhash의 값과 동일한지 확인
	 * </p>
	 * @return 해시코드값이 동일하면 true, 다르면 false 값 반환
	 * @author kym
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Book) {
			if (((Book) obj).bookName.hashCode() == bookhash);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @see 책 정보와 대여 가능여부
	 * @return isBorrowed 값을 확인하여 대여가능여부 문자열을 반환
	 * @author kym
	 */
	@Override
	public String toString() {
		String result = "[책 이름] " + this.bookName + ", [저자] " + this.writer + "입니다."
				+ (isBorrowed ? "이미 대여중입니다." : "대여 가능합니다.");
		return result;
	}

}

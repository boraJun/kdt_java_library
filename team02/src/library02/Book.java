package library02;

public class Book implements Borrow {

	private String name;
	private String writer;
	private boolean isBorrowed;
	private int bookhash;

	public Book(String name, String writer) {
		this.name = name;
		this.writer = writer;
		this.bookhash = name.hashCode();
	}
	
	

	public String getName() {
		return name;
	}



	public String getWriter() {
		return writer;
	}



	@Override
	public boolean borrowBook() throws BookNotAvailableException {
		if (isBorrowed == true) {
			throw new BookNotAvailableException("다른 고객님이 대여중입니다.");
		} else {
			this.isBorrowed = true;
			return this.isBorrowed;
		}
	}

	@Override
	public boolean returnBook() {
		this.isBorrowed = false;
		return this.isBorrowed;
	}

	@Override
	public int hashCode() {
		return this.bookhash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Book) {
			if(((Book)obj).name.hashCode() == bookhash);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		String result = "[책 이름] " + this.name + ", [저자] " + this.writer + "입니다.";
		return result;
	}

}

package library02;

public class BookNotAvailableException extends Exception{
//	private String msg; //사용하지 않음

	public BookNotAvailableException(String msg) {
		super(msg);
//		this.msg = msg; //사용하지 않음
	}
	
}

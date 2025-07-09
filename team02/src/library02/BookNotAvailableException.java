package library02;

public class BookNotAvailableException extends Exception{
	private String msg;

	public BookNotAvailableException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
}

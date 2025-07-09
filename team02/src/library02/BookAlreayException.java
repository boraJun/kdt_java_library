package library02;

public class BookAlreayException extends Exception{
	private String msg;

	public BookAlreayException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
}

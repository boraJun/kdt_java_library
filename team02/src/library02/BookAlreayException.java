package library02;

public class BookAlreayException extends Exception{
//	private String msg; //사용하지 않음

	public BookAlreayException(String msg) {
		super(msg);
//		this.msg = msg; //사용하지 않음
	}
	
}

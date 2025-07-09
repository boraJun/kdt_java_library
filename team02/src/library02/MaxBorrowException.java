package library02;

public class MaxBorrowException extends Exception{
	private String msg;

	public MaxBorrowException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
}

package library02;

public interface Borrow {
	
	public abstract boolean borrowBook() throws BookNotAvailableException;
	public abstract boolean returnBook();
	
}

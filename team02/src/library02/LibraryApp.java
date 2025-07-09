package library02;


import java.awt.Menu;
import java.util.Scanner;

public class LibraryApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ConsoleUI console = new  ConsoleUI();
		LoginManager login = new LoginManager();
		LibraryService scrvice = new LibraryService();
		
		console.printMenu();
		login.login(null, null);
		
		console.printloginMenu();
		
		
		System.out.println(scrvice.getBookList());
		
		
		

		
		
		
		
	}
}

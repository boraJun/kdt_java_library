package library02;


import java.awt.Menu;
import java.util.Scanner;

public class LibraryApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ConsoleUI console = new  ConsoleUI();
		LoginManager login = new LoginManager();
		
		
		
		

		
		
		
		while(true) {
			System.out.println("번호를 선택하세요: " + console.printMenu);
			console.printMenu(sc.nextInt());
			
			
			
		
			
			break;
		}
		
	}
}

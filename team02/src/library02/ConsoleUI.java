package library02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI {
	LoginManager login = new LoginManager();
	LibraryService service = new LibraryService();
	
	Scanner sc = new Scanner(System.in);
	
	// 필드
	String printMenu = "\n0. 시스템 종료"+
			 			"\n1. 로그인 "+
						"\n2. 회원가입";
	
	String loginMenu = "\n1. 나의 도서정보"+
						"\n2. 도서관 책목록 조회";
	
	String rentlabook = "대여";
	String returnbook = "반납";
						
	String id;
	String pw;			
	String name;
	

	public  void printMenu(){
		System.out.println(printMenu);
	}
	
	public void printloginMenu() {
		System.out.println(loginMenu);		
	}
	
	
	
	
	public void printRnetalBookList() {
		service.getBookList();
	}
	
	public void printReturnBookList() {
		login.getUser(id);
	}
	
}

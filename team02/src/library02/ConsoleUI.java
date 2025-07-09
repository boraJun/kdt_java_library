package library02;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
	//LoginManager login = new LoginManager();
	//LibraryService service = new LibraryService();
	
	Scanner sc = new Scanner(System.in);
	
	// 필드
	String printMenu = "\n0. 시스템 종료"+
			 			"\n1. 로그인 "+
						"\n2. 회원가입";
	
	String loginMenu = "\n1. 나의 도서정보"+
						"\n2. 도서관 책목록 조회"+
						"\n3. 로그아웃";
	
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
	
	public String inputLogin(int num) {
		if (num == 1) {
			return login();
		} else if(num == 2) {
			return addUser();
		}else {
			return null;
		}
	}
	
	public String addUser(){
		System.out.println("회원가입 화면 id: ");
		id = sc.nextLine();
		System.out.println("회원가입 화면 pw: ");
		pw = sc.nextLine();
		System.out.println("회원가입 화면 name: ");
		name = sc.nextLine();
		return LibraryApp.login.addMember(id, pw, name) ? id : null;
	}
	
	public String login() {
		System.out.println("로그인 화면 id: ");
		id = sc.nextLine();
		System.out.println("로그인 화면 pw: ");
		pw = sc.nextLine();
		return LibraryApp.login.login(id, pw) ? id : null;
	}
	
	public void printRnetalBookList() {
		List<String> list = LibraryApp.scrvice.getBookList();
		for(String str : list)
			System.out.println(str);
		System.out.println();
	}
	
	public void printReturnBookList() {
		LibraryApp.login.getUser(id);
	}
	
}

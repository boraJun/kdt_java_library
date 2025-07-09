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
	

	public void printMenu(int num){
		
			if(num == 1) { // 
				System.out.println("아이디 비밀번호 입력해주세요");
				login();
			}else if(num == 2) {
				System.out.println("회원가입 창입니다");
				System.out.println("아이디 비밀번호 이름을 입력해주세요");
				 sdgknkdsgl();
		}
	}
	
	private void login() {
		login.login(id = sc.nextLine(), pw = sc.nextLine());
		
	}
	
	public void sdgknkdsgl() {
		login.addMember(id = sc.nextLine(), pw =sc.nextLine() , name =sc.nextLine() );
	}
	
	
	public void printRnetalBookList() {
		
	}
	
	public void printReturnBookList() {
		
	}
	
}

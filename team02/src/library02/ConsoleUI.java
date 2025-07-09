package library02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI {
	LoginManager login = new LoginManager();
	
	
	// 필드
	String printMenu = "0. 시스템 종료"+
			 			"\n1. 로그인 "+
						"\n2. 로그아웃" +
						"\n3. 회원가입";
	
	String loginMenu = "1. 나의 도서정보"+
						"\n2. 도서관 책목록 조회"+
						"\n3. 대여"+
						"\n4. 반납";
							
	
	

	public void printMenu(int num){
		try {
			if(num == 1) { // 
				System.out.println("아이디 비밀번호 입력해");
			}else if(num == 2) {
				 System.out.println("로그아웃 하시렵니까");
			}else if(num == 3) {
				System.out.println("회원가입 ");
			}
				 
		}catch(InputMismatchException e) {
			
		}catch(Exception e) {
			
		}
	}
	
	
	
	public void printRnetalBookList() {
		
	}
	
	public void printReturnBookList() {
		
	}
	
}

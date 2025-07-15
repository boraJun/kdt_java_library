package library02;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LibraryApp {

	static LibraryService scrvice;
	static LoginManager login;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ConsoleUI console = new ConsoleUI();
		scrvice = new LibraryService();
		login = new LoginManager();

		String id;
		String pw;
		String name;
		String book;
		int num = -1;

		while (true) { // 기존회원은 로그인, 최초회원은 회원가입
			console.printMenu();
			System.out.println("사용할 번호입력");

			try {

				num = sc.nextInt();
				sc.nextLine();
				if (num == 0)
					break;
				id = console.inputLogin(num);

				if (id == null) {
					System.out.println("실패");
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("숫자를 입력하세요");
				continue;
			}

			Member sss = (Member) login.getUser(id);

			while (true) { //
				console.printloginMenu();
				System.out.println("사용할 번호입력");
				try {
					num = sc.nextInt();
					sc.nextLine();
				} catch (InputMismatchException e) {
					System.out.println("숫자를 입력하세요");
					sc.nextLine();
					continue;
				}

				if (num == 1) { // 1번 로그인 선택
					try { // 예외가 발생할 수 있는 코드
						List<String> list = sss.getRentedBooks();

						if (list.size() != 0) {
							for (String str : list)
								System.out.println(str);
							System.out.println();
							System.out.println("반납할 책이름: ");
							book = sc.nextLine();
							boolean result = scrvice.returnBook(sss, book);

							if (!result) {
								System.out.println("반납 실패");
							}
						} else {
							System.out.println("반납할 책이 없습니다.");
						}
					} catch (NullPointerException e) {
						System.out.println("대여한 책이 없습니다.");
					}

				} else if (num == 2) {
					console.printRnetalBookList();

					System.out.println("대여할 책이름: ");
					book = sc.nextLine();
					try {
						System.out.println(scrvice.rentalBook(sss, book) ? "대여 성공" : "대여 실패");
					} catch (MaxBorrowException e) {
						System.out.println(e.getMessage());
					} catch (BookNotAvailableException e) {
						System.out.println(e.getMessage());
					} catch (NullPointerException e) {
						System.out.println("책 이름이 존재하지 않습니다.");
					}
				} else if (num == 3) {
					break;
				}

			}
		}
		sc.close();
	}

}

import java.util.Scanner;

public class App {
	private Scanner sc;

	public App(Scanner sc) {
		this.sc = sc;
	}

	public void run() {
		System.out.println("== 명언 앱 실행 ==");
		// trim() : 혹시 있을지 모르는 좌우 공백 제거
		int lastId = 1;

		while (true) {
			System.out.print("명령어 ) ");
			String cmd = sc.nextLine().trim();

			if (cmd.equals("종료")) {
				break;
			} else if (cmd.equals("등록")) {
				System.out.print("명언 : ");
				String content = sc.nextLine().trim();
				System.out.print("작가 : ");
				String author = sc.nextLine().trim();
				System.out.printf("%d번 명언이 등록되었습니다.", lastId);
				lastId++;
			}
		}
	}
}
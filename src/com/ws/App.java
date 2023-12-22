package com.ws;

import com.ws.system.controller.SystemController;
import com.ws.wiseSaying.controller.WiseSayingController;

public class App {

	private byte system_status = 1; // 반복문의 종료시점을 설정하기위해 쓰였다

	public App() { // 앱 생성자를 만들었다

	}

	public void run() { // run 메서드
		System.out.println("== 명언 앱 실행 ==");

		SystemController systemController = new SystemController(); // SystemController를 불러오기위해 쓰였다.
		WiseSayingController wiseSayingController = new WiseSayingController(); // WiseSayingController를 ''

		while (system_status == 1) { // 반복문이 위 바이트값과 참이면 실행된다.
			System.out.print("명령어 ) ");
			String cmd = Container.getScanner().nextLine().trim(); // 컨테이너 클래스의 스캐너를 가져오고 좌우공백을 지우는 코드를 썼다.
			Rq rq = new Rq(cmd); // Rq객체에 명령어를 넘겨줬다.

			switch (rq.getActionCode()) { // switch문 활용 rq에 있는 액션코드를 리턴받았다.
			case "종료":
				systemController.exit(); // systemController에 있는 출력문을 출력한다.
				system_status = 0; // 위 바이트값이 0이되면 while문이 거짓이 되어 반복문 탈출
				break;
			case "등록":
				wiseSayingController.write(); // wiseSayingController에 있는 write 메서드의 출력문을 볼러온다
				break;
			case "목록":
				wiseSayingController.list(); // wiseSayingController에 있는 list 메서드의 출력문을 볼러온다
				break;
			case "삭제":
				wiseSayingController.remove(rq); // wiseSayingController에 있는 remove 메서드의 출력문을 볼러온다
				break;
			case "수정":
				wiseSayingController.modify(rq); // wiseSayingController에 있는 modify 메서드의 출력문을 볼러온다
				break;

			default:
				System.out.println("존재하지 않는 명령어입니다");
				break;
			}
		}
	}
}

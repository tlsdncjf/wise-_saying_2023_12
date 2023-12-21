package com.ws;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ws.system.controller.SystemController;
import com.ws.wiseSaying.controller.WiseSayingController;
import com.ws.wiseSaying.entity.WiseSaying;

public class App {
	private Scanner sc;

	public App(Scanner sc) {
		this.sc = sc;
	}

	public void run() {
		System.out.println("== 명언 앱 실행 ==");

		SystemController systemController = new SystemController();
		WiseSayingController wiseSayingController = new WiseSayingController(sc);

		int lastId = 0;
		List<WiseSaying> wiseSayings = new ArrayList<>();

		while (true) {
			System.out.print("명령어 ) ");
			String cmd = sc.nextLine().trim();

			if (cmd.equals("종료")) {
				systemController.exit();
				break;
			} else if (cmd.equals("등록")) {
				wiseSayingController.write();
			} else if (cmd.equals("목록")) {
				wiseSayingController.list();
			} else {
				System.out.println("존재하지 않는 명령어입니다");
			}
		}
	}
}

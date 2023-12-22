package com.ws.wiseSaying.controller;

import java.util.List;
import com.ws.Rq;
import com.ws.Container;
import com.ws.wiseSaying.entity.WiseSaying;
import com.ws.wiseSaying.servise.WiseSayingService;

public class WiseSayingController {
	private WiseSayingService wiseSayingService;

	public WiseSayingController() {
		wiseSayingService = new WiseSayingService(); // WiseSayingService객체 생성
	}

	public void write() { // write 메서드
		System.out.print("명언 : ");
		String content = Container.getScanner().nextLine().trim(); // 컨테이너에 있는 스캐너씀
		System.out.print("작가 : ");
		String author = Container.getScanner().nextLine().trim(); // 컨테이너에 있는 스캐너씀
		int id = wiseSayingService.write(content, author); // wiseSayingService에 있는 리턴값
		System.out.printf("%d번 명언이 등록되었습니다.\n", id);
	}

	public void list() { // list 메서드
		List<WiseSaying> wiseSayings = wiseSayingService.findAll();

		System.out.println("번호  /  작가  /  명언  ");
		System.out.println("=".repeat(30)); // "="이걸 30번쓰겠다는 뜻

		for (int i = wiseSayings.size() - 1; i >= 0; i--) { // 반복문
			WiseSaying ws = wiseSayings.get(i); // i는 wiseSayings.size()

			System.out.printf("%d  /  %s  /  %s\n", ws.getId(), ws.getAuthor(), ws.getContent());
		}
	}

	public void remove(Rq rq) { // remove 메서드에 rq사용
		int id = rq.getIntParam("id", -1); // IntParam에 있는 name과 defaultValue의 값 지정

		if (id == -1) { // id가 -1과 참이라면 아래 출력문 출력
			System.out.println("id(정수)를 제대로 입력해주세요");
			return; // 위 출력문 출력되면 다시 리턴해서 명령어 입력
		}
		// 입력된 id와 일치하는 명언 객체 찾기
		WiseSaying wiseSaying = wiseSayingService.findById(id); // 

		if (wiseSaying == null) {
			System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
			return;
		}

		// 찾은 명언 객체를 object기반으로 삭제
		wiseSayingService.remove(wiseSaying);

		System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
	}

	public void modify(Rq rq) {
		int id = rq.getIntParam("id", -1); // IntParam에 있는 name과 defaultValue의 값 지정

		if (id == -1) { // id가 -1과 참이라면 아래 출력문 출력
			System.out.println("id(정수)를 제대로 입력해주세요");
			return;
		}
		// 입력된 id와 일치하는 명언 객체 찾기
		WiseSaying wiseSaying = wiseSayingService.findById(id);

		if (wiseSaying == null) {
			System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
			return;
		}

		// 찾은 명언 객체를 object기반으로 수정
		System.out.println("명언(기존) :" + wiseSaying.getContent());
		System.out.println("작가(기존) :" + wiseSaying.getAuthor());

		System.out.print("명언 : ");
		String content = Container.getScanner().nextLine().trim();
		System.out.print("작가 : ");
		String author = Container.getScanner().nextLine().trim();

		wiseSayingService.modify(wiseSaying, content, author);

		System.out.printf("%d번 명언이 수정되었습니다.\n", id);

	}

}
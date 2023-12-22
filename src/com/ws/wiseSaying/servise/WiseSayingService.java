package com.ws.wiseSaying.servise;

import java.util.List;

import com.ws.wiseSaying.entity.WiseSaying;
import com.ws.wiseSaying.repository.WiseSayingRepository;

public class WiseSayingService {
	private WiseSayingRepository wiseSayingRepository; // wiseSayingRepository에 접근제한 설정

	public WiseSayingService() { // WiseSayingService생성자 만듦.

		wiseSayingRepository = new WiseSayingRepository(); // WiseSayingService객체 만듦
	}

	public List<WiseSaying> findAll() { // List<WiseSaying>생성자
		return wiseSayingRepository.findAll(); // 리턴벨류
	}

	public int write(String content, String author) { // write 메서드 생성 인자 2개
		return wiseSayingRepository.write(content, author); // wiseSayingRepository에 리턴할 때 인자 두개도 같이준다
	}

	public WiseSaying findById(int id) { // WiseSaying
		return wiseSayingRepository.findById(id);
	}

	public void remove(WiseSaying wiseSaying) {
		wiseSayingRepository.remove(wiseSaying);

	}

	public void modify(WiseSaying wiseSaying, String content, String author) {
		wiseSayingRepository.modify(wiseSaying, content, author);
	}
}
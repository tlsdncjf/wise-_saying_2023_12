package com.ws.wiseSaying.controller;

import com.ws.Rq;
import com.ws.wiseSaying.servise.WiseSayingService;

public class WiseSayingController {
	private WiseSayingService wiseSayingService;
	
	public WiseSayingController() {
		wiseSayingService = new WiseSayingService();
	}

	public void write(String content, String author) {
		wiseSayingService.write(content, author);
	}

	public void list() {
		wiseSayingService.list();
	}

	public void remove(Rq rq) {
		wiseSayingService.remove(rq);
	}

	public void modify(Rq rq) {
		wiseSayingService.modify(rq);

	}

}
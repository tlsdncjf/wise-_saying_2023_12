package com.ws.wiseSaying.entity;

public class WiseSaying {
	private int id;  // 정수인 번호를 접근제한 설정했다
	private String content; // 문자열인 명언에 접근제한 설정했다
	private String author; // 문자열인 작가를 접근제한 설정했다

	public WiseSaying(int id, String content, String author) { // 인자 3개를 넣은 WiseSaying생성자를 만들었다.
		this.id = id; // 자신이 가진객체의 id에 접근
		this.content = content; // 자신이 가진객체의 content에 접근
		this.author = author; // 자신이 가진객체의 author에 접근

	}

	public int getId() { // Id를 외부로 전달하기 위해쓰였다
		return id;
	}

	public void setId(int id) { // id를 리턴하기위해 쓰였다
		this.id = id;
	}

	public String getContent() { // ''
		return content;
	}

	public void setContent(String content) { // ''
		this.content = content;
	}

	public String getAuthor() { // ''
		return author;
	}

	public void setAuthor(String author) { // ''
		this.author = author;
	}

}
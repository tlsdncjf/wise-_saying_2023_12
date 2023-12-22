package com.ws; // 명언 프로젝트의 기능별로 패키지를 만들었다

public class Main {
	public static void main(String[] args) {

		Container.init(); // 컨테이너 클래스에있는 스캐너를 가져오기 위해 쓰였다

		new App().run(); // 앱 클래스를 실행

		Container.getScanner().close(); // 컨테이너 클래스의 스캐너를 종료하기 위해 쓰였다.
	}
}
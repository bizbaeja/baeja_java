package ch06.sec02;

public class 자동차메인 {

	public static void main(String[] args) {
		//객체 생성 
		자동차 아영차 = new 자동차("빨간색");  //생성자 함수 호출 
		자동차 길동차 = new 자동차();  //생성자 함수 호출 
		자동차 순신차 = new 자동차("흰색", 100);  //생성자 함수 호출 
		자동차 순신차2 = new 자동차("G90", "흰색");  //생성자 함수 호출 
		
		아영차.정보출력();
		아영차.속도 = 10;
		
		System.out.println("아영차 색상 : "  + 아영차.get색상());

	}

}

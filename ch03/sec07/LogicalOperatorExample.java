package ch03.sec07;

public class LogicalOperatorExample {
	public static void main(String[] args) {
		int charCode = 'F';
		//int charCode = 'a';
		//int charCode = '5';

		System.out.println((int) 'A');
		System.out.println((int) 'Z');
		
		if( ('A' <= charCode) & (charCode <= 'Z') ) {
			System.out.println("대문자이군요.");
		}
			
		if( ('a' <= charCode) && (charCode <= 'z') ) {
			System.out.println("소문자이군요.");
		}

		if( ('0' <= charCode) && (charCode <= '9') ) {
			System.out.println("0~9 숫자이군요.");
		}
		
		//----------------------------------------------------------

		//초록색  : 색상 : 32bit  
		//RGB     : 투명도:빨간색:초록새:파란색
		//0x         00    FF     00     FF 
		//0x00FF00FF
		
		int value = 6;
		//int value = 7;
			
		if( (value%2==0) | (value%3==0) ) {
			System.out.println("2 또는 3의 배수이군요.");
		}

		boolean result = (value%2==0) || (value%3==0);
		if( !result ) {
			System.out.println("2 또는 3의 배수가 아니군요.");
		}
	}
}
package ch03.sec04;

public class AccuracyExample2 {
	public static void main(String[] args) {
		int apple = 1;//정수계산기
		int totalPieces = apple * 10;//정수계산기
		int number = 7;//정수계산기
		
		int result = totalPieces - number; //정수계산기 
		System.out.println("10조각에서 남은 조각: " + result);
		System.out.println("사과 1개에서 남은 양: " + result/10.0);//실수계산기
		
		if (Math.abs(result/10.0 - 0.3) < 0.0001) {
			//실수 값의 조건에 만족하는 경우 처리 함 
		}
	}
}
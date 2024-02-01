package ch05.sec06;

public class ArrayCreateByValueListExample1 {
	public static void main(String[] args) {
		
		//초기화, 대입
		//int [] score = new int[10000];
//		int  score[] = new int[10000];
		
		int [] score = {10,20,30,40,50,60,70,80,90,100}; //String str = "Hello";
		               //위 코드는 초기화시 사용가능
		         
		int [] score2 = null;
		int [] score3 = new int [] {10,20,30,40,50,60,70,80,90,100}; //String str = "Hello";
		                //위 코드는 초기화 및 대입시 사용 가능  
		                //new에 의해 별도의 메모리에 할당됨 
						//위 코드는 대입시 사용할 수 있기 때문에 메소드의 인자로 전달 할 수 있음
		
		score2 = score;
		
		//score3 = {10,20,30,40,50,60,70,80,90,100};
		//score3 = new int [] {10,20,30,40,50,60,70,80,90,100};
		score3 = new int [1000];
		score2 = new int [] {10,20,30,40,50};
		
		
		System.out.println(score.length);
		System.out.println(score2.length);
		System.out.println(score3.length); //1000
		score3 = new int [100];
		System.out.println(score3.length); //100
		
		//배열에 값을 기록 
		for (int i=0;i<score3.length;++i) {
			score3[i] = i * 10 + 10;
		}
		
		//배열의 값을 읽기  
		for (int i=0;i<score3.length;++i) {
			 System.out.println(score3[i]);
		}
		
		//배열에 값을 기록, 배열의 값을 읽기 
		for (int i=0;i<score3.length;++i) {
			score3[i] = i * 10 + 10;
			System.out.println(score3[i]);
		}
		
		//배열 변수 선언과 배열 생성
		String[] season = { "Spring", "Summer", "Fall", "Winter" };

		//배열의 항목값 읽기
		System.out.println("season[0] : " + season[0]);
		System.out.println("season[1] : " + season[1]);
		System.out.println("season[2] : " + season[2]);
		System.out.println("season[3] : " + season[3]);

		//인덱스 1번 항목의 값 변경
		season[1] = "여름";
		System.out.println("season[1] : " + season[1]);
		System.out.println();

		//배열 변수 선언과 배열 생성
		int[] scores = { 83, 90, 87 };

		//총합과 평균 구하기
		int sum = 0;
		for(int i=0; i<3; i++) {
			sum += scores[i];
		}
		System.out.println("총합 : " + sum);
		double avg = (double) sum / 3;
		System.out.println("평균 : " + avg);
	}
}
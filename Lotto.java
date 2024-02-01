
public class Lotto {
	//1. 배열을 이용하여 구슬을 설정하다
	final int [] arr = new int[45];
	//2. 결과 저장할 배열을 만든다 
	final int [] result = new int [6];

	//생성자 함수 
	//1. 배열을 이용하여 구슬을 설정하다
	Lotto() {
		for (int i=0;i<arr.length;++i) {
			arr[i] = i+1;
		}
	}

	void assign() {
		//3. 구슬을 뽑는다
		for (int i=0;i<6;++i) {
			final int idx = (int)(Math.random() * (arr.length - i));    
			//해당 위치에 있는 값을 결과 배열로 이동 
			result[i] = arr[idx];

			//사용된 요소의 값에 배열의 마지막 값을 설정한다
			arr[idx] = arr[arr.length - 1 - i];
		}
	}
	
	void printLotto() {
		//4. 결과 출력 
		for (int value : result) {
			System.out.println(value);
		}
	}
	
	void foo() {
//		arr = new int[10];
//		result = new int[200];
	}

	public static void main(String[] args) {
		//객체 생성 
		Lotto lotto = new Lotto();
		
		lotto.assign();
		
		lotto.foo();
		
		lotto.printLotto();
	}

}

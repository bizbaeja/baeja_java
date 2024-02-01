package ch04.sec04;

public class FloatCounterExample {
	public static void main(String[] args) {
//		int sum = 0;
//		for (int i=0;i<1000;++i) {
//			//문장
//			sum = sum + 1;
//		}
//		
//		System.out.println(sum);
		
		//for(float x=0.1f; x<=1.0f; x+=0.1f) {
		for(int x=1; x<=10; ++x) {
			System.out.println((float)(x/10f));
		}
	}
}
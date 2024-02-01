package ch05.sec09;

public class ArrayCopyByForExample {
	public static void main(String[] args) {
		//길이 3인 배열 
		int[] oldIntArray = new int[9000];//{ 1, 2, 3, 4,5,6,7 };
		//길이 5인 배열을 새로 생성
		int[] newIntArray = new int[10000];
		//배열 항목 복사
//		newIntArray[0] = oldIntArray[0];
//		newIntArray[1] = oldIntArray[1];
//		newIntArray[2] = oldIntArray[2];
		//long tick = System.nanoTime(); //백만분의1초 
		long tick = System.currentTimeMillis();//천분의 1초 
		for(int i=0; i<oldIntArray.length; i++) {
			newIntArray[i] = oldIntArray[i];
		}
		//tick = System.nanoTime() - tick;
		tick = System.currentTimeMillis() - tick;
		System.out.println("for 실행 시간 : " + tick);
		
//		tick = System.nanoTime();
		tick = System.currentTimeMillis();
		System.arraycopy( oldIntArray, 0, newIntArray, 0, oldIntArray.length);
//		tick = System.nanoTime() - tick;
		tick = System.currentTimeMillis() - tick;
		System.out.println("arraycopy 실행 시간 : " + tick);

		//배열 항목 출력
//		for(int i=0; i<newIntArray.length; i++) {
//			System.out.print(newIntArray[i] + ", ");
//		}
	}
}
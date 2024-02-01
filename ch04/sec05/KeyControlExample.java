package ch04.sec05;

import java.lang.reflect.Field;
import java.util.Scanner;

class 학생 {
	String 이름;
	int 나이;
	int 학번;
	
	static int id = 20240101; //공유 정보 
	
	학생() {
		학번 = ++id ;
	}
	void print() {
		
	}
	
	
}
/*
 * 상수 : 변하지 않는 값 
 * 변수 : 값이 변경될 수 있는 저장공간  
 *
 * 오류 : 1. 구문오류 (컴파일 : 빠르게 찾을 수 있음)
 *        2. 논리오류 (개발자 디버깅 : 기산이 오래 걸림)
 *           일정부분 변수를 사용하지 않고 상수변수를 사용하여 처리 하면 논리오류를 
 *           컴파일로 찾을 수 있다  
 * 
 */
public class KeyControlExample {
	public static int foo() {
		return 10;
	}

	public static int sum(int end) {
		int sum = 0;
		for (int i=1;i<=end;++i) {
			sum += i;
		}
		return sum;
	}
	
	public static void main(String[] args) {
//		String  str = null;
//		System.out.println(str.length());
		
		final int sum = sum(100);
//		sum = 10;
		System.out.println("sum = " + sum);
		
		final String name1 = "홍길동";
		final String name2 = new String("홍길동");
		final String name3 = "자바 프로그래밍, 자바 프로그래밍";

//		System.out.println(name1.charAt(-3));
		System.out.println(name3.substring(3));
		System.out.println(name3.substring(3, 5));
		System.out.println(name3);
		
		final int idx1 = name3.indexOf("자");
		if (idx1 != -1) {
			final int idx2 = name3.indexOf("자", idx1 + 1);
			System.out.println("두번째 '자'가 있는 위치 " + idx2);
			System.out.println("두번째 '자'가 있는 위치 " + name3.indexOf('자', idx1 + 1));
		}
		
		System.out.println(name3.indexOf("자"));
		System.out.println(name3.indexOf("저"));
		System.out.println(name3.indexOf("프"));
		
		if (name1.equals(name2)) {
			
		}
//		Scanner scanner = null;
//		scanner = new Scanner(System.in);
//		boolean run = true;
//		int speed = 0;
//
//		while(run) {
//			System.out.println("-----------------------------");
//			System.out.println("1. 증속 | 2. 감속 | 3. 중지");
//			System.out.println("-----------------------------");
//			System.out.print("선택: ");
//
//			String strNum = scanner.nextLine();
//
////			if(strNum.equals("1")) {
////				speed++;
////				System.out.println("현재 속도 = " + speed);
////			} else if(strNum.equals("2")) {
////				speed--;
////				System.out.println("현재 속도 = " + speed);
////			} else if(strNum.equals("3")) {
////				run = false;
////			}
////			switch(strNum){
////			case "1": 
////				speed++;
////				System.out.println("현재 속도 = " + speed);
////				break;
////			case "2":
////				speed--;
////				System.out.println("현재 속도 = " + speed);
////				break;
////			case "3":
////				run = false;
////				break;
////			}
//			int a = 0;
////			a = foo();
////			
////			foo();
//			
////			run = switch(strNum){
////				case "1" -> { 
////					speed++;
////					System.out.println("현재 속도 = " + speed);
////					yield true;
////				}
////				case "2" -> {
////					speed--;
////					System.out.println("현재 속도 = " + speed);
////					yield true;
////				}
////				case "3" -> false;
////				default -> true;
////			};
//			
////			switch(strNum){
////				case "1" -> { 
////					speed++;
////					System.out.println("현재 속도 = " + speed);
////				}
////				case "2" -> {
////					speed--;
////					System.out.println("현재 속도 = " + speed);
////				}
////				case "3" -> run = false;
////			}
//
//			run = switch(strNum){
//				case "1" -> { 
//					speed++;
//					yield true;
//				}
//				case "2" -> {
//					speed--;
//					yield true;
//				}
//				case "3" -> false;
//				default -> true;
//			};
//			
//			if (run) {
//				System.out.println("현재 속도 = " + speed);
//			}
//			
//			//switch case 문으로 변경 
//			//switch case exp(->) 문으로 변경 
//		}
//
//		System.out.println("프로그램 종료");
	}
}
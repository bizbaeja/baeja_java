package ch02.sec08;

public class Example {
	public static void main(String[] args) {
		System.out.println("args.length = " + args.length);
		if (args.length >= 1) System.out.println("args[0] = " + args[0]);
		if (args.length >= 2) System.out.println("args[1] = " + args[1]);
		if (args.length >= 2) {
			int result = Integer.parseInt(args[0]) + Integer.parseInt(args[1]);
			System.out.println("result = " + result);
			System.out.println("result = " + String.valueOf(result));
//			String str = "" + result;
			String str = String.valueOf(result);
			System.out.println("str = " + str);
			//문자열 정수를 정수로 변환 하고자 함 
			//입력인자      리턴값
//			class Integer {
//				static int parseInt(String value) {
//					
//				}
//			}
		}
		int a = 10;
	}
}

/*
 * 변수 : 영역 , 
 *        전역, 멤버, 지역
 *        
 *  자바에서 전역 변수를 선언하여고 하면 static 로 선언 해야한다 
 * 
 * 클래스 : 멤버 변수와 멤버 메소드로 구성된다 
 *          속성,  기능 

 *  자동차 : 색상, 속도, 크기, 생산수량 -> 속성
 *           static int 생산수량;
             static int 생산수량() { return 생산수량;}
              
 *           시동을 건다
 *           우회전 한다
 *           가속한다 
 *           멈춘다 
 *         
 *  자동차  홍길동승용차 = new 자동차();
 *  자동차  이순신승용차 = new 자동차();
 *  
 *  홍길동승용차.시동을건다()
 *  홍길동승용차.색상 = "빨간색";
 *  홍길동승용차.생산수량(); //x 
 *  자동차.생산수량(); //  1 
 *  
 *  이순신승용차.시동을건다()
 *  이순신승용차.색상 = "파란색";
 *  자동차.생산수량(); //  2 
 *  
 *  
 *   
 *  
 *  
 * */

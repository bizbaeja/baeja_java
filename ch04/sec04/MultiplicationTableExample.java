package ch04.sec04;

public class MultiplicationTableExample {
	
	public static void dan_display(int dan) {
		System.out.println("\n========" + dan + " 단 =====");
		for (int i=1;i<=9;++i) {
			System.out.println(dan + " * " + i + " = " + dan*i);
		}
	}
	
	public static void main(String[] args) {
		
		for (int dan=2;dan<=9;dan++) {
			dan_display(dan);
		}
		
//		for (int i=1;i<=9;++i) {
//			System.out.println("3 * " + i + " = " + 3*i);
//		}
//		
//		for (int i=1;i<=9;++i) {
//			System.out.println("4 * " + i + " = " + 4*i);
//		}

//		for (int m=2; m<=9; m++) {
//			System.out.println("*** " + m + "단 ***");
//			for (int n=1; n<=9; n++) {
//				System.out.println(m + " x " + n + " = " + (m*n));
//			}
//		}
	}
}
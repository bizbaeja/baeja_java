package ch03.sec01;

public class SignOperatorExample {
	public static void main(String[] args) {
		int x = -100;
		x = -x;
		System.out.println("x: " + x);

		byte b = 100;
		short s = 100;
		b = (byte)(10-b);
		s = (short)(-s);
		int y = -b;
		System.out.println("y: " + y);
		
	}
}
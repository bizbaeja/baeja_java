package ch03.sec01;

public class IncreaseDecreaseOperatorExample {
	public static void main(String[] args) {
		int x = 10;
		int y = 10;
		int z;

		//기계어, 어셈블리, 고급언어 
		//x = x - 1; //inc , dec
		
		x = 10;
		x++; //후위형
		System.out.println("11  x=" + x);		
		
		x = 10;
		++x; //전위형
		System.out.println("11  x=" + x);		

		System.out.println("-----------------------");		
		y--;
		--y;
		System.out.println("y=" + y);		

		x = 10;
		System.out.println("-----------------------");		
		z = x++; //z = 10, x = 11, //조금늦음 
		System.out.println("10 z=" + z);
		System.out.println("11 x=" + x);
		
		System.out.println("-----------------------");		
		x = 10;
		z = ++x; //x = 11, z = 11,  //조금빠름
		System.out.println("11 z=" + z);
		System.out.println("11 x=" + x);
		
		System.out.println("-----------------------");
		x = 10;
		y = 10;
		z = ++x + y++; // x = 11, y = 10 , z = 21, y = 11
		System.out.println("z=" + z);
		System.out.println("x=" + x);
		System.out.println("y=" + y);
	}
}
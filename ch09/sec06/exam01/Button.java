package ch09.sec06.exam01;

class A {
	   public void foo() {
	      System.out.println("A.foo()...");
	   }
	}

	class B extends A {
	   public void foo() {
	      System.out.println("B.foo()...");
	   }
	}

	class C extends A {
	   public void foo() {
	      System.out.println("C.foo()...");
	   }
	}

	public class Button {
	   //정적 멤버 인터페이스
	   public static interface ClickListener {
	      //추상 메소드
	      void onClick();
	   }
	   
	   //실행시 cmd  
	   //java ch09.sec06.exam01.Button 10 20
	   //sum = 30
	   public static void main(String [] args) throws Exception {
//	      int x = Integer.parseInt(args[0]);
//	      int y = Integer.parseInt(args[1]);
//	      int sum = x + y;
//	      System.out.println("sum = " + sum);
	      //"ch09.sec06.exam01.A"
	      Class cls = Class.forName(args[0]);
	      A obj = (A) cls.newInstance();
	      //A obj = new A();
	      obj.foo();
	   }
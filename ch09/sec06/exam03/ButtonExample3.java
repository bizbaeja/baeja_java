package ch09.sec06.exam03;

import ch09.sec06.exam03.Button.ClickListener;

public class ButtonExample3 {
	public static void main(String[] args) {
		//Ok 버튼 객체 생성
		Button btnOk = new Button();
		btnOk.click();

		//Ok 버튼 클릭 이벤트를 처리할 ClickListener 구현 클래스(로컬 클래스)
		class OkListener implements Button.ClickListener {
			@Override
			public void onClick() {
				System.out.println("Ok 버튼을 클릭했습니다.");
			}
		}
		//인터페이스, 추상클래스로는 객체를 만들수 없으나, 예외적으로 생성가능- 익명의 클래스 
				// new 추상클래스|인터페이스 (){
				//  (추상메소드 재정의)
				//}
		Button.ClickListener listner = new Button.ClickListener() {
			@Override
			public void onClick() {
				System.out.println("Ok 버튼을 클릭했습니다.");
			}
		};

		//Ok 버튼 객체에 ClickListener 구현 객체 주입
		btnOk.setClickListener(listner);
		
		//Ok 버튼 클릭하기
		btnOk.click();

		//-----------------------------------------------------------------------------
		
		//Cancel 버튼 객체 생성
		Button btnCancel = new Button();

		//Cancel 버튼 클릭 이벤트를 처리할 ClickListener 구현 클래스(로컬 클래스)
		class CancelListener implements Button.ClickListener {
			@Override
			public void onClick() {
				System.out.println("Cancel 버튼을 클릭했습니다.");
			}
		}
		
		//Cancel 버튼 객체에 ClickListener 구현 객체 주입
		btnCancel.setClickListener(new CancelListener());
		
		//Cancel 버튼 클릭하기
		btnCancel.click();
	}
}
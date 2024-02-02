package ch09.sec06.exam03;

public class ButtonExample2 {
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
		//참조변수로 만들어서 대체해본 케이스 
		//왼쪽 추상클래스나 인터페이스 오른쪽은 자식이 온다. 
		OkListener listner = new OkListener();

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
package ch06.sec02;

public class 자동차 {
	private String 모델;
	private String 색상;
	int 속도 = 10;
	
//	public 자동차(String 색상) {
//		this.색상 = 색상;
////		this.속도 = 0;
//	}
//	
	public 자동차() {
	}
	
	public 자동차(String 색상) {
		this("기본모델", 색상);
//		this.모델 = "기본모델";
//		this.색상 = 색상;
//		this.속도 = 0;
		
		return ;
	}
	
	public 자동차(String 모델, String 색상) {
		this(모델, 색상, 0);
//		this.모델 = 모델;
//		this.색상 = 색상;
		
		return ;
	}

	public 자동차(String 색상, int 속도)  {
		this("기본모델", 색상, 속도);
//		this.색상 = 색상;
//		this.속도 = 속도;
	}

	public 자동차(String 모델, String 색상, int 속도)  {
		this.set모델(모델);
		this.색상 = 색상;
		this.속도 = 속도;
		
		정보출력();//this.정보출력()
	}
	
	public void 정보출력() {
		System.out.println("자동차 색상 : " + 색상);
		System.out.println("자동차 속도 : " + 속도);
	}

	public String get색상() {
		return 색상;
	}

	public int get속도() {
		return 속도;
	}
	
	public void foo() {
		정보출력();
	}
//	public String get색상() {
//		return 색상;
//	}

	public String get모델() {
		return 모델;
	}

	public void set모델(String 모델) {
		this.모델 = 모델;
	}
	
}

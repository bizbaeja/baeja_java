package ch04.sec07;

public class BreakOutterExample {
	public static void main(String[] args) throws Exception {
		exit_loop: 
		for(char upper='A'; upper<='Z'; upper++) {
			for(char lower='a'; lower<='z'; lower++) {
				System.out.println(upper + "-" + lower);
				if(upper == 'B' && lower == 'g') {
					break exit_loop;
				}
			}
		}
		System.out.println("프로그램 실행 종료");
	}
}
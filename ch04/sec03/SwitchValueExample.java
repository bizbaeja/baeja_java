package ch04.sec03;

public class SwitchValueExample {
	
	public static int switch_function(String grade) {
		switch(grade) {
	    case "A":
	    	return 100;
	    case "B":
	    	return 100 - 20;
	    default:
	    	return 60;
		}
	}
	
	public static void main(String[] args) {
		String grade = "B";
		
		//Java 11 이전 문법
		int score1 = 0;
		switch(grade) {
		    case "A":
		    	score1 = 100;
		    	break;
		    case "B":
		    	int result = 100 - 20;
		    	score1 = result;
		    	break;
		    default:
		    	score1 = 60;
		}
		System.out.println("score1: " + score1);
		
		score1 = switch_function(grade);
		System.out.println("score1: " + score1);
		
		//Java 14부터 가능
		int score2 = switch(grade) {
			case "A" -> 100;
			case "B" -> {
				int result = 100 - 20;
				yield result;
			}
			case "C" -> {
				int temp = 100 - 20;
				temp = (int) Math.round(temp * 10.5);
				yield temp;
			}
			default -> 60;
		};
		System.out.println("score2: " + score2);
	}
}
public class SwitchExample {
    public static void main(String[] args){
        char grade = 'B';
    //switch 문의 괄호에는 정수타입(byte, char, short, int, long)과 문자열 타입 변수만 사용이 가능하다.
//        switch (grade){
//            // grade 의 값이 'a' 이거나 'A' 라면 sout 을 실행한다.
//            case 'A':
//            case 'a':
//                System.out.println("우수 회원입니다.");
//                break;
//            case 'B':
//            case 'b':
//                System.out.println("일반 회원입니다.");
//                break;
//            default:
//                System.out.println("손님입니다.");
//        }

        switch (grade){
            //Java12 부터 가능
            // 실행문이 한 줄이라면, 중괄호를 없앨 수도 있다.
            case'A','a'-> {
                System.out.println("우수 회원입니다.");
            }
            case'B','b'-> {
                System.out.println("일반 회원입니다.");

            }
            default -> {
                System.out.println("손님입니다.");
            }
        }

    }
}

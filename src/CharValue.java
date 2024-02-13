public class CharValue {
    public static void main(String[] args) {
// 주민번호 성별을 구분해내는 문제.
        String ssn = "9503122787654";
        char sex = ssn.charAt(6);
        switch (sex){
            case '1':
            case '3':
                System.out.println("남자입니다.");
                break;
            case '2':
            case '4':
                System.out.println("여자입니다.");
                break;

        }
    }
}

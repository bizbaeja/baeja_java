public class ReplaceStrings {
    public static void main(String[] args) {
        // 자바에서 문자열은 불변이다. 따라서 replace 메소드가 작동하는 방식은 문자열을 대체한 새로운 문자열을
        // 만들기 때문에 주소는 다르다.
        // 힙 영역에서 만들어지는 문자열 객체는 문자열 'a' 와 'b'의 번지가 다르다.
        // toString() 메소드를 이용하면 인스턴스의 클래스이름과 해시코드를 출력한다.
        String oldStr = "자바 문자열은 불변입니다. 자바 문자열은 String 입니다.";
        String newStr = oldStr.replace("자바","JAVA");

        System.out.println(System.identityHashCode(oldStr));
        System.out.println(System.identityHashCode(newStr));
    }
}

package Method;

public class MethodDeclare {
    //<----선언부 ------------------>
    // 리턴타입 메소드명 (매개변수...,...){실행블록}
    // void 로 선언하면 리턴값이 없는 메소드이다. 메시지 보내, 읽어들여와!
    double divide(int x, int y) {
        double result = (double) x /(double) y;
        return result;
    }
    // 위와 같이 반드시 return  을 반환해야 하며, 반환값의 타입은 앞에 선언한 double 임
    // 메소드의 호출 방법
    // 객체 내부 : 메소드명으로 호출
    // 객체 외부 : 참조변수 .(도트)
}

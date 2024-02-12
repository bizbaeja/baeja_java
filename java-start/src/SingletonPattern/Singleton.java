package SingletonPattern;

public class Singleton {
    // 애플리케이션에서 단 한개의 객체만 생성해서 사용하고 싶을 떄.
    // 외부에서 new 연산자로 생성자를 호출할 수 없도록 만드는 것.
    // private 접근 권한을 갖는 정직 필드 선언과 초기화
    private static Singleton singleton = new Singleton();

    //private 접근 권한을 갖는 생성자 선언
    private Singleton(){}

    // public 접근 권한을 갖는 정적 메소드 선언
    static Singleton getInstance(){
        return singleton;
    }


}

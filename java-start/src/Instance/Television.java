package Instance;

public class Television {
    static String company = "my company";
    static String model= "LCD";
    static String info;
// 정적 블록은 해당 클래스를 사용할 시점에 자동적으로 실행이 된다.
    static  {
        System.out.println("1");
        info = "정보:" + company;
        info = "-" + model;
    }
    static {
        System.out.println("2");
    }
}

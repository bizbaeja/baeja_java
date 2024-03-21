package clean.code.design6.data.movie.step00;

public class Customer {
    private String name;
    private String id;
    private static int generationId = 1;
//팩토리 메소드. 생성자를 private으로 선언하여 외부에서 생성자를 호출하지 못하도록 함
//팩토리 패턴 : 객체 생성을 담당하는 클래스를 별도로 두어 객체 생성을 캡슐화하는 방식
    private Customer(String name, String id) {
        this.id = id;
        this.name = name;
    }

    private static int getNextId() {
        return generationId++;
    }

    public static Customer createCustomer(String name) {
        return new Customer(String.valueOf(getNextId()), name);
    }
}

package ch16.sec05.exam03_01;

public class ConstructorRef {

    public static void main(String[] args) {
       Company company = new Company();

       Product p1 = company.getProduct1(id -> new Product(id));
        System.out.println(p1);

       Product p2 = company.getProduct2((id,name)-> new Product(id,name));
        System.out.println(p2);
    }
}

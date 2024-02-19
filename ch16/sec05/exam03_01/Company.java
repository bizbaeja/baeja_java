package ch16.sec05.exam03_01;

public class Company {
    public Product getProduct1(Creatable1 creatable1){
        String id = "새우깡";
        Product product = creatable1.create(id);
        return  product;
    }

    public  Product getProduct2(Creatable2 creatable2){
        String id = "1111";
        String name = "먹태깡";
        Product product = creatable2.create(id, name);
        return product;
    }
}

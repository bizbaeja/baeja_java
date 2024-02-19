package ch16.sec05.exam03_01;

public class Product {
    private String id;
    private String name;

    public Product(String id,String name) {
        this.id = id;
        this.name = name;
    }

    public  Product(String id) {
    this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

package ch17.sec12.exam03_01;

public class Patient {
    private String name;
    private String sex;
    private int age;
    public  Patient(String name,String sex, int age){
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }
}

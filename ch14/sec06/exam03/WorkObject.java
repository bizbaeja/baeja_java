package ch14.sec06.exam03;


public class WorkObject {
    private int a;
    private int b;
    private int result;

    public int getA() {
        return a;
    }
    public int getB() {
        return b;
    }

    public  int calc(){
        return result = a + b;

    }
    public void setA(int a) {
        this.a = a;
    }
    public void setB(int b) {
        this.b = b;
    }

    public int getResult() {
        return result;
    }

}
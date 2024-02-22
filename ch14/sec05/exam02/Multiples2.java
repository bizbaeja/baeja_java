package ch14.sec05.exam02;

public class Multiples2 extends Thread {
    private long multiples;
    private long num;

    public long getMultiples() {
        return multiples;
    }
    public void setMultiples(long multiples) {
        this.multiples = multiples;
    }
    public Multiples2(long num) {
        this.num = num;
        this.multiples = 1;
    }
    @Override
    public void run() {
          if(num % 2 == 0) {
            for(int i=1; i<=num; i++) {
                if(i % 2 == 0) {
                    multiples *= i;
                }
            }
        }
    }



}

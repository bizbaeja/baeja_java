package ch14.sec06.exam03;

public class CalcThread extends Thread {
    private WorkObject workObject;

    public CalcThread(WorkObject workObject) {
        setName("CalcThread");
        setDaemon(true);
        this.workObject = workObject;
    }

    @Override
    public void run() {
        for (int i=0;i<5;i++) {
            System.out.println("계산 중");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
workObject.calc();

        synchronized(workObject) {
            // workObject 를 사용할 모든 스레드를 깨운다.
            workObject.notifyAll();
        }
    }
}
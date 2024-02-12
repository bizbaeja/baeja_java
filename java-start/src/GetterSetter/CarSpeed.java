package GetterSetter;

public class CarSpeed {
    public static void main(String[] args) {
        Speed myCar = new Speed();
        myCar.setSpeed(-50);
        System.out.println(myCar.getSpeed());

        myCar.setSpeed(60);
        System.out.println(myCar.getSpeed());

        if(!myCar.isStop()){
            myCar.setStop(true);
        }
        System.out.println(myCar.getSpeed());
    }
}

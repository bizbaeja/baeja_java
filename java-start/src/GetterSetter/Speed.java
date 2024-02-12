package GetterSetter;

public class Speed {
    private double speed;
    private boolean stop;
// 외부에서의 직접적인 필드 접근을 막고 대신 메소드를 통해 필드에 접근하게 한다.
    public void setSpeed(int speed){
        if(speed<0){
            this.speed = 0;
            return;
        }else{
            this.speed = speed;
        }
    }
// return 이 있기 때문에 리턴타입은 필드타입과 동일하게
    // 불리언 타입일 경우 is 로 시작하는게 관례
    public double getSpeed(){
        return speed;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
        if(stop){
            this.speed = 0;
        }
    }
}

package DailyRoutine;

public class WeekdayRoutine implements WakeUp,FeedCat,Transport,GotoSleep,Eat {
    @Override
    public void feed() {
        System.out.println("일어나자마자 밥을 줍니다.");
    }

    @Override
    public void take() {
        System.out.println("대중교통을 탑니다.");
    }

    @Override
    public void wake() {
        System.out.println("7시에 일어납니다.");

    }

    @Override
    public void sleep() {
        System.out.println("11시에 잡니다.");
    }


    void takeAShower() {
        System.out.println("샤워를 합니다.");
    }

    void checkIn() {
        System.out.println("체크인을 합니다.");
    }

    ;

    void checkOut() {
        System.out.println("체크아웃을 합니다.");
    }

    void attendClass() {
        System.out.println("자현 굿이야~");
    }

    boolean hasHomework() {
        return false;
    }

    static void doHomework() {
        System.out.println("과제를 합니다.");
    }

    @Override
    public void eatLunch() {
        System.out.println("지하 구내식당을 갑니다.");
    }

    @Override
    public void eatAnything() {
        System.out.println("아무거나 먹습니다.");
    }
}

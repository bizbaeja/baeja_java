package DailyRoutine;

public class HolidayRoutine implements Cleaning,FeedCat,GotoSleep,WakeUp,Eat {
    @Override
    public void cleaning() {
        System.out.println("청소를 합니다.");
    }

    @Override
    public void feed() {
        System.out.println("조금 이르거나 늦게 줍니다.");
    }

    @Override
    public void sleep() {
        System.out.println("일찍 자도록 합니다.");
    }

    @Override
    public void wake() {
        System.out.println("일어나고 싶을 때 일어납니다.");
    }


    @Override
    public void eatLunch() {
        System.out.println("점심을 먹습니다.");
    }

    @Override
    public void eatAnything() {
        System.out.println("아무거나 먹습니다.");
    }
}
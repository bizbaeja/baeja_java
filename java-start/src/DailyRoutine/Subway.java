package DailyRoutine;

public class Subway implements Transport {
    @Override
    public void take() {
        System.out.println("지하철을 탑니다. 매우 붐빕니다. 살려줘요");
    }
}

package clean.code.design6.step04;
import clean.code.design6.data.movie.step00.DiscountConditionType;

import java.time.DayOfWeek;
import java.time.LocalTime;


public class DiscountCondition {
    private DiscountConditionType type;
    private int sequence;          // 할인 조건 순번
    private DayOfWeek dayOfWeek;   // 기간 조건 요일
    private LocalTime startTime;   // 기간 조건 시작 시간
    private LocalTime endTime;     // 기간 조건 종료 시간

    // 순번 조건을 위한 생성자
    public DiscountCondition(int sequence) {
        this.type = DiscountConditionType.SEQUENCE;
        this.sequence = sequence;
    }

    // 기간 조건을 위한 생성자
    public DiscountCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.type = DiscountConditionType.PERIOD;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // 주어진 상영 정보가 이 할인 조건을 만족하는지 판단하는 메서드
    public boolean isSatisfiedBy(Screening screening) {
        if (type == DiscountConditionType.PERIOD) {
            return screening.getWhenScreened().getDayOfWeek().equals(dayOfWeek) &&
                    screening.getWhenScreened().toLocalTime().compareTo(startTime) >= 0 &&
                    screening.getWhenScreened().toLocalTime().compareTo(endTime) <= 0;
        }
        return sequence == screening.getSequence();
    }

    // Getter 메서드들...
}
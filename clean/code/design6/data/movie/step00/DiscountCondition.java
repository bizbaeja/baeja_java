package clean.code.design6.data.movie.step00;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {
    private DiscountConditionType type;
    //private int sequence; //할인조건(순번:0, 기간:1) ->안좋은 방법, enum으로 변경
    // symbolic constant pattern : enum으로 변경
    // 논리적인 오류를 컴파일 오류로 변경 가능

    private int sequence; //순번

    private DayOfWeek dayOfWeek; //기간 요일
    private LocalTime startTime; //기간 시작시간
    private LocalTime endTime;   //기간 종료시간
// 순번 조건 생성자
    public DiscountCondition(int sequence) {
        this(DiscountConditionType.SEQUENCE, sequence, DayOfWeek.of(1), LocalTime.of(0,0), LocalTime.of(0,0));
    }
// 기간 조건 생성자
    public DiscountCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this(DiscountConditionType.PERIOD, 0, dayOfWeek, startTime, endTime);
    }

    public DiscountConditionType getType() {
        return type;
    }

    public void setType(DiscountConditionType type) {
        this.type = type;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

// 멤버변수에 대한 생성자 멤버변수에 대해 총괄적으로 초기화하는 생성자
    private DiscountCondition(DiscountConditionType type, int sequence, DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.type = type;
        this.sequence = sequence;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

}

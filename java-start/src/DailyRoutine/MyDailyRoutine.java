package DailyRoutine;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class MyDailyRoutine {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        DayOfWeek dayOfWeek = today.getDayOfWeek();

        System.out.println("Today is " + dayOfWeek + " 가보자고!");
        System.out.println();


        HolidayRoutine holidayRoutine = new HolidayRoutine();
        WeekdayRoutine weekdayRoutine = new WeekdayRoutine();


        // 요일에 따른 루틴 실행
        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            // 주말 루틴
            holidayRoutine.wake();
            holidayRoutine.eatAnything();
            holidayRoutine.cleaning();
            holidayRoutine.feed();
            holidayRoutine.sleep();

        } else {
            // 주중 루틴
            weekdayRoutine.wake();
            weekdayRoutine.takeAShower();
            if (weekdayRoutine.isWakeEarly()){
                weekdayRoutine.takeBus();
            }else {
                weekdayRoutine.takeSubway();
            }
            weekdayRoutine.checkIn();
            weekdayRoutine.attendClass();
            weekdayRoutine.eatLunch();
            weekdayRoutine.attendClass();
            weekdayRoutine.checkOut();
            weekdayRoutine.takeBus();
            if (weekdayRoutine.hasHomework()){
                WeekdayRoutine.doHomework();
            }else{
            weekdayRoutine.sleep();}

        }
    }
}
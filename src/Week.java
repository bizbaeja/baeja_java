import java.util.*;
public class Week {
    public static void main(String[] args) {
        //열거 타입 변수 선언

        //열거값 대입
        Weekend.Week today =  Weekend.Week.MONDAY;


        //컴퓨터의 정보 얻기
        Calendar now = Calendar.getInstance();
        int week = now.get(Calendar.DAY_OF_WEEK);


        switch (week){
            case '1': today  = Weekend.Week.SUNDAY; break;
            case '2': today = Weekend.Week.MONDAY; break;
            case '3': today = Weekend.Week.TUESDAY; break;
            case '4': today = Weekend.Week.WENDEDAY; break;
            case '5': today = Weekend.Week.THURSEDAY; break;
            case '6': today = Weekend.Week.FRIDAY; break;
            case '7': today = Weekend.Week.SATURDAY; break;
        }

        if(today != Weekend.Week.FRIDAY){
            System.out.println("오늘은 불금이 아닙니다.");
        }else{
            System.out.println("TGIF!!");
        }
    }
}

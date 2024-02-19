package ch16.sec05.exam02_01;

public class Snack {
    public void exercise(Comparable2 comparable2){
        String 다이제 = "939kcal";
        String 홈런볼 = "270kcal";

        int result = comparable2.compare(다이제,홈런볼);
        if(result<0){
            System.out.println( 다이제 +"는" + 홈런볼 +"보다 칼로리가 낮습니다");
        }else if(result == 0){
            System.out.println(다이제 + "와" + 홈런볼 + "의 칼로리는 같습니다.");

        }else {
            System.out.println(다이제 +"는"+ 홈런볼 +"보다 칼로리가 높습니다.");
        }
    }
}

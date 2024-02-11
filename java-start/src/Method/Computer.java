package Method;

public class Computer {
    //가변길이 매개변수를 갖는 메소드 선언
    //매개변수 선언도 변수 선언이다.
    int sum(int ... values){
        int sum = 0;
// values 는 배열 타입의 변수처럼 사용
        for(int i=0; i<values.length;i++){
            sum += values[i];
        }

        return sum;
    }
}

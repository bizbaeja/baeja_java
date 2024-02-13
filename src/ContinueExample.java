public class ContinueExample {
    public static void main(String[] args) {
// for 문일 경우에는 continue 키워드를 만났을 때 for 문의 증감식으로 돌아간다
// while 문일 경우에는  continue 키워드를 만났을 때 while 문의 조건문으로 돌아간다.
        for(int i=1; i<=10; i++){
            if(i%2 != 0){
                continue;
            }
            System.out.println(i+ " ");
        }

    }
}

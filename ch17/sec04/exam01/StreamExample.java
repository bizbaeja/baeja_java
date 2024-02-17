package ch17.sec04.exam01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
		//List 컬렉션 생성
		List<Product> list = new ArrayList<>();
		//배열에 요소 삽입
		for(int i=1; i<=5; i++) {
//			Product product = new Product(i, "상품"+i, "멋진회사", (int)(10000*Math.random()));
//			list.add(product);
			//4byte를 아끼고 실수를 아낄 수 있다.
			// product  = null; 지역변수는 최대한 지양한다.
			list.add(new Product(i, "상품"+i,"멋진회사",(int)(1000*Math.random())));
		}
		//배열롤 스트림얻어서 화면에 출력하기
		long tick = System.nanoTime();
		for(var product :list){ //외부에 관련된 것.
			System.out.println(product);
		}//-> 스트림으로 변경해보자는 것(forEach) //내부에 관련된 것 람다구문으로
		tick= System.nanoTime() - tick;
		System.out.println("실행시간"+tick);

		//객체 스트림 얻기
		long tick2 = System.nanoTime();
		Stream<Product> stream = list.stream();
		//stream.forEach(p->System.out.println(p));
		stream.forEach(System.out::println);
		tick2= System.nanoTime() - tick2;
		System.out.println("실행시간2"+tick2);
	}
}
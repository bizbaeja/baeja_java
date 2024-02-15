package ch17.sec01.exam01;

import javax.xml.namespace.QName;
import java.util.*;
import java.util.stream.Stream;

public class StreamExample {
	//db없이 자료구조를 검색을 할 수 있다! 반복문을 실행할 수 있다.
	public static void main(String[] args) {
		List<String> array = new ArrayList<>();

		array.add("홍길동");
		array.add("신용권");
		array.add("김자바");

		for(int i=0;i<array.size();i++){
			System.out.println(array.get(i));
		}
		for (String name : array){
			System.out.println(name);
		}
		// 병렬처리에 효율적이다.
		// 람다식으로 다양한 요소 처리를 정의한다.
		// 재사용이 불가능하다.최종은 단 한 번!
		// 최종처리란? 결과값을 구하면 그걸 가지고 재가공이 불가능하다. final임


		//Stream<String> stream = array.stream();
		//stream.forEach(name-> System.out.println(name));
		//Set 컬렉션 생성
		Set<String> set = new HashSet< >();
		set.add("홍길동");
		set.add("신용권");
		set.add("감자바");
//name 이 리턴되었을 때 값이 외부 . next() 엔진이 내부.라고 가정
		// 내부 반복자, 외부 반복자.
		Iterator<String> it = set.iterator();
		while (it.hasNext()){
			String name = it.next();
			System.out.println(name);
		}
		//Stream을 이용한 요소 반복 처리
		Stream<String> stream = set.stream();
		stream.forEach( name -> System.out.println(name) );
	}
}
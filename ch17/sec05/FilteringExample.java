package ch17.sec05;

import ch17.sec04.exam01.Product;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//필터링은 if 문을 말한다.
public class FilteringExample {
	public static void main(String[] args) {
		//List 컬렉션 생성
		List<Product> listProduct = new ArrayList<>();

		for(int i=1; i<=5; i++) {
			listProduct.add(new Product(i, "상품"+i, "멋진회사", (int)(10000*Math.random())));
		}
		listProduct.add(new Product(1, "상품1", "멋진회사", (int)(10000*Math.random())));

		listProduct.stream()
				.forEach(p -> System.out.println(p));
		System.out.println();

		listProduct.stream()
				.distinct()
				.forEach(p -> System.out.println(p));
		System.out.println();

		//List 컬렉션 생성
		List<String> list = new ArrayList<>();
		list.add("홍길동"); 	list.add("신용권");
		list.add("감자바");		list.add("신용권");		list.add("신민철");

		Set<String> set = new HashSet<>();
		//순서를 만들고 싶음
		List<Integer> posArray = new ArrayList<>();
		int pos = 0;
		for(String str : list){
			if(set.add(str)){
				posArray.add(pos);
			}
			int i = pos++;

			System.out.println(set);
			System.out.println(posArray);
//			for(String str: list){
//				if(set.add(str)){
//
//				}
//			}
		}
		System.out.println(set);
		//나는 위와 같은 코딩을 하지 않아도 된다.
		//중복 요소 제거
		list.stream()
			.distinct()
			.forEach(n -> System.out.println(n));
		System.out.println();

		//신으로 시작하는 요소만 필터링
		list.stream()
				// 내부적으로 if 문의 역할을 한다.
				// 리턴타입이 스트림임
			.filter(n -> n.startsWith("신"))
			.forEach(n -> System.out.println(n));
		System.out.println();

		//중복 요소를 먼저 제거하고, 신으로 시작하는 요소만 필터링
		list.stream()
			.distinct()
				//추상메소드가 아니면 내부에서 사용하는 메소드란 소리임
			.filter(n -> n.startsWith("신"))
			.forEach(n -> System.out.println(n));
	}
}
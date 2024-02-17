package ch17.sec06.exam03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class FlatMappingExample {
	public static void main(String[] args) {
		//문장 스트림을 단어 스트림으로 변환
		List<String> list1 = new ArrayList< >();
		list1.add("this is java");
		list1.add("i am a best developer");

//      List<String> newArr = new ArrayList<String>();
//      for (var str : list1) {
//         StringTokenizer token = new StringTokenizer(str, " ");
//         while(token.hasMoreTokens()) {
//            newArr.add(token.nextToken());
//         }
//      }
//      System.out.println(newArr);

		List<String> newArr = new ArrayList<String>();
		for (var str : list1) {
			String [] arr = str.split(" ");
			for (var token : arr) {
				newArr.add(token);
			}
		}
		System.out.println(newArr);

/*스트림 방식에서는 list1.stream()을 호출하여 리스트를 스트림으로 변환합니다.
스트림은 데이터 컬렉션을 함수형 스타일로 처리할 수 있게 해주는 연속된 데이터 요소들의 시퀀스입니다.
* */
		list1.stream().
				//flatMap 메서드는 각 문장(스트림의 요소)을 받아서 data.split(" ")을 통해 공백 기준으로 단어로 분리한 다음,
				// Arrays.stream()을 사용하여 단어 배열을 새로운 스트림으로 변환합니다.
				flatMap(data -> Arrays.stream(data.split(" ")))
				.forEach(word -> System.out.println(word));
		//마지막으로 forEach 메서드는 스트림의 각 요소(여기서는 단어)를 출력합니다.
//결과적으로, 원래의 스트림(문장들의 스트림)은 단어들의 스트림으로 "평탄화"(flatMap)됩니다.
// 즉, 여러 문장들이 단일 스트림의 단어들로 변환되는 것입니다.
		System.out.println();

		//문자열 숫자 목록 스트림을 숫자 스트림으로 변환
		List<String> list2 = Arrays.asList(
				"10, 20, 30",
				"40, 50"
		);
		list2.stream()
				//flatMapToInt 메서드는 flatMap과 유사하지만, 결과로 IntStream(정수들의 스트림)을 생성합니다.
				.flatMapToInt(data -> {
					//문자열을 쉼표로 분리한 후 (split(",")), 각 부분을 정수로 변환합니다 (Integer.parseInt).
					// 이렇게 변환된 정수들은 새로운 IntStream을 형성합니다.
					String[] strArr = data.split(",");
					int[] intArr = new int[strArr.length];
					for (int i = 0; i < strArr.length; i++) {
						intArr[i] = Integer.parseInt(strArr[i].trim());
					}
					return Arrays.stream(intArr);
				})
				.forEach(number -> System.out.println(number));
		System.out.println();

		//향상된 for loop 변경 ver1
		list2.stream()
				.flatMapToInt(data -> {
					String[] strArr = data.split(",");
					int[] intArr = new int[strArr.length];
					int i = 0;
					for (var str : strArr) {
						intArr[i++] = Integer.parseInt(str.trim());
					}
					return Arrays.stream(intArr);
				})
				.forEach(number -> System.out.println(number));
		System.out.println();

		//향상된 for loop 변경 ver2
		list2.stream()
				.flatMapToInt(data -> {
					String[] strArr = data.split(", ");
					List<Integer> intArr = new ArrayList<Integer>();
					for (var str : strArr) {
						intArr.add(Integer.parseInt(str));
					}
					return intArr.stream().mapToInt(o -> o.intValue());
				})
				.forEach(number -> System.out.println(number));
		System.out.println();

		//mapToInt() 변경 ver1
		list2.stream()
				.flatMapToInt(data -> {
					String[] strArr = data.split(", ");
					return Arrays.stream(strArr).mapToInt(s -> Integer.parseInt(s));
				})
				.forEach(number -> System.out.println(number));
		System.out.println();

		//mapToInt() 변경 ver2
		list2.stream()
				.flatMapToInt(data -> {
					return Arrays.stream(data.split(", ")).mapToInt(s -> Integer.parseInt(s));
				})
				.forEach(number -> System.out.println(number));
		System.out.println();

		//mapToInt() 변경 ver3
		list2.stream()
				.flatMapToInt(data -> {
					return Arrays.stream(data.split(", ")).mapToInt(Integer::parseInt);
				})
				.forEach(number -> System.out.println(number));
		System.out.println();
	}
}
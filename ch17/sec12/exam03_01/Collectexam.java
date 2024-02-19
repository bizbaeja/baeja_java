package ch17.sec12.exam03_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collectexam {
    public static void main(String[] args) {
        List<Patient> totalList = new ArrayList<>();
        totalList.add(new Patient("배땃쥐","여자",15));
        totalList.add(new Patient("서해달","남자",13));
        totalList.add(new Patient("김자바","여자",17));
//Map<String, List<Patient>> 형태의 맵을 반환하는데, 여기서
// 키는 성별이고 값은 해당 성별을 가진 Patient 객체들의 리스트입니다.
        Map<String, Double> map = totalList.stream()
                .collect(
                        Collectors.groupingBy(
                                s-> s.getSex(),
                                Collectors.averagingDouble(s-> s.getAge())

                        )
                );
        System.out.println(map);

        Map<String, List<String>> map1 = totalList.stream()
                .collect(
                        Collectors.groupingBy(
                                Patient::getSex,
                                Collectors.mapping(
                                        Patient::getName,
                                        Collectors.toList()
                                )
                        )
                );
        System.out.println(map1);
    }
}

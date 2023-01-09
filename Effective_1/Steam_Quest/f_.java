package Effective_1.Steam_Quest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class f_ {
    //남성 회원 이름의 List와 여성 회원 이름의 List가 있습니다.
    // 남성 회원과 여성 회원 중 특정 성씨를 갖고 있는 사람의 명단이 필요합니다.
    // 중복된 이름은 제거하고 특정 성씨를 갖고 있는 회원들의 이름을 정렬한 후 List로 리턴해야 합니다.
    public List<String> findPeople(List<String> male, List<String> female, String lastName) {
        //TODO..
//        List<String> a = male.stream().filter(e -> e.startsWith(lastName))
//                .collect(Collectors.toList());
//        List<String> b = female.stream().filter(e->e.startsWith(lastName))
//                .collect(Collectors.toList());
//        return Stream.concat(a.stream(),b.stream()).sorted().distinct().collect(Collectors.toList());
        //거르고 합친거
        return Stream.concat(male.stream(),female.stream())
                .distinct().sorted().filter(e -> e.startsWith(lastName))
                .collect(Collectors.toList()); // 합치고 거른거

    }
}

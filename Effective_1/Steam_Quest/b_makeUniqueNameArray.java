package Effective_1.Steam_Quest;

import java.util.List;

public class b_makeUniqueNameArray {
    //String 타입을 요소로 가지는 List를 입력받아 중복을 제거하고
    // 정렬한 후 String 타입을 요소로 갖는 배열로 리턴해야 합니다.
    public String[] makeUniqueNameArray(List<String> names) {
        String[] result = names.stream() // String 타입 배열로 스트림 생성
                .distinct() // 중복 객체 제거
                .sorted() // 사전편찬 순으로 정렬
                .toArray(String[]::new); // 다시 String 타입의 배열로 생성
        return result;
    }
}

package Effective_1.Steam_Quest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class e_mergeTwoStream {
    public List<String> mergeTwoStream(List<String> list1, List<String> list2) {
        return Stream // 최상위 클래스인 Stream 호출해서
                .concat(list1.stream(),list2.stream()) // Stream 클래스에 있는 메소드로 두 개 엮어줌
                .collect(Collectors.toList()); // 이후 다시 리스트 화하면 땡
    }
}

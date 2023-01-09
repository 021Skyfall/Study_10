package Effective_1.Steam_Quest;

import java.util.List;

public class c_filterName {
    //String타입을 요소로 가지는 List를 입력받아
    // 중복을 제거하고 김씨 성을 가진 이름들을 정렬하여 문자열 배열로 리턴해야 합니다.
    //주의 사항
    //반복문(for, while) 사용은 금지됩니다.
    //입력받은 리스트에 김씨가 없거나, 리스트의 크기가 0인 경우 0을 리턴해야 합니다.
    //정렬은 사전식 순서로 정렬 되어야 합니다.
    public String[] filterName(List<String> names) {
        String[] result = names.stream()
                .filter(e -> e.startsWith("김")) // 김으로 시작하는 조건 삽입
                .distinct() // 중복 제거
                .sorted() // 정렬
                .toArray(String[]::new); // 배열 생성
        return result;
    }
}
// 이건 그리 어렵지 않게 풀긴했는데
// 주의사항에 있는 점 때문에 .orElse() 넣으려했는데 안들어가더라고
// 이유를 정확히 모르겠어서 가져옴
// 근데 지금 생각해보니까 결국 result 를 출력하는 거고
// result 는 무조건 내가 저 스트림 걸어논 것만 출력됨
// 즉, filterName 메소드를 호출 한다 하더라도 내가 걸어놓은 조건의 배열만 출력된다는 것이고
// 이건 즉 김씨 없거나 리스트 크기가 0 이면 걍 0 나오겠지
// 정확한지는 모름

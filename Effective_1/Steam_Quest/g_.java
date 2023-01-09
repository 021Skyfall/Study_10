package Effective_1.Steam_Quest;

import java.util.Arrays;

public class g_ {
    //이번주의 최고 온도만을 모아놓은 List를 분석하여 이번주가 더웠는지 알아봅시다.
    // 최고 기온이 30도를 넘은 날이 3일 이상이면 true를, 그렇지 않다면 false를 리턴해야 합니다.
    public boolean isHot(int[] temperature) {
        // int[] result = Arrays.stream(temperature)
        //             .filter(e -> e >= 30).toArray();
        //     if (result.length >= 3) return true;
        //     return false;
        // 위는 내가 푼거
//        return Arrays.stream(temperature)
//                .filter(e -> e >= 30)
//                .count() >= 3 ? true : false;
                // 그냥 count() 를 먹인거 자체가 Long 타입 정수로 나오니까
                // 바로 수랑 비교한 다음에 boolean 출력하면 되네 하
        return Arrays.stream(temperature)
                .filter(e -> e >= 30)
                .count() >= 3; // >> 삼항연산자 없어도 이거 자체가 boolean 으로 출력되네

    }
}

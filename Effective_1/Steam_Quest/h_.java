package Effective_1.Steam_Quest;

import java.util.Arrays;

public class h_ {
    // String 타입을 요소로 가지는 배열을 입력받아,
    // 가장 길이가 긴 문자열 요소의 길이를 리턴해야 합니다.
    public int findLongestLength(String[] strArr) {

//        if (strArr.length == 0) return 0;
//        return Arrays.stream(strArr).mapToInt(String::length).max().getAsInt();
        //내가 푼거
        // reduce 사용 ↓
        return Arrays.stream(strArr)
                .mapToInt(str -> str.length())
//              .reduce(0,(a,b) -> a > b ? a : b); // < 삼항 연산자 들어가도 되는 거 몰랐다;
                                                    // 먼저 들어오는 a가 b보다 크면 a 그대로
                                                    // 리듀스로 반복
//                  or
//              .reduce(0, (a,b) -> Math.max(a, b)); // 얘는 위의 삼항연산자를 Math 클래스의 max 메소드 사용
                                                      // 해서 바꾼거
                                                      // max 메소드는 둘 중에 큰거 return
                                                      // 그러니까 위랑 같은거지 뭐
//                  or
                .reduce(0,Math::max); // 마지막으로 줄인 얘는 바로 위 메소드를
                                                // 메소드 참조로 줄인거
                                                // 참조는? 변수 삭제, 클래스 :: 메소드
    }
}

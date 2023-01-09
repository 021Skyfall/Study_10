package Effective_1.Steam_Quest;


import java.util.Arrays;

public class d_findLongestLength {
    //String 타입을 요소로 가지는 배열을 입력받아,
    // 가장 길이가 긴 문자열 요소의 길이를 리턴해야 합니다.
    public int findLongestLength(String[] strArr) {
        if (strArr.length == 0) return 0;
        return Arrays.stream(strArr) // 배열에 스트림 먹이기
                .mapToInt(String::length) // 해당 스트링 타입의 배열 객체를 length 먹여서 길이만 내오고 int 로 타입 변경
                .max() // 그 중에서 가장 큰거
                .getAsInt(); // 인트로 출력
    }
}

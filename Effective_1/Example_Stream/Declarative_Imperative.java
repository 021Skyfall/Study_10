package Effective_1.Example_Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Declarative_Imperative {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,3,5,7,9,11);
        int sum = 0;

        // 명령형 프로그래밍
        for (int x : list) {
            if (x > 4){
                sum+=x;
            }
        }
        System.out.println("명령형 프로그래밍 : "+sum);
        // 기존에 하던대로 for-each 문으로 순회 후 합계 계산

        // 선언형 프로그래밍
        int sum1 =
                list.stream()
                        .filter(x -> x > 4)
                        .mapToInt(x -> x)
                        .sum();
        System.out.println("선언형 프로그래밍 : "+sum1);
        // stream 을 이용한 합계 계산
        // 전부 메소드 + 람다식 이라 이해하기 훨씬 직관적이긴 함
        // 아직 코드를 짧게 넣어서 간결한지는 몰?루겠음

        List<String> fruitList = List.of("바나나 ", "사과 ", "오렌지");
        String[] fruits = {"오렌지 ", "사과 ", "바나나"};
        // 리스트랑 배열 생성
        Stream<String> str = fruitList.stream();
        // 리스트 스트림 적용
        Stream<String> str2 = Arrays.stream(fruits);
        // 배열 스트림 적용
        str.forEach(System.out::print); // 리스트 순회
        System.out.println();
        str2.forEach(System.out::print); // 배열 순회
    }
}

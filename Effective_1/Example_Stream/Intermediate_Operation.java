package Effective_1.Example_Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Intermediate_Operation {
    public static void main(String[] args) {
        //필터링
        List<String> ns = Arrays.asList("a뭐 ","a요 ","b인마 ","a어쩌 ","b라구요 ","c라구요");
        // List 니까 stream 바로 사용 가능
        ns.stream()
                .distinct() // 중복 제거
                .forEach(System.out::print);
        System.out.println();
        ns.stream()
                .distinct()
                .filter(e -> e.startsWith("a")) // a 로 시작하는 문자열 거르기
                .forEach(System.out::print);
        System.out.println();
        ns.stream()
                .map(e -> e.toUpperCase()) // 대문자 전환
                .forEach(System.out::print); // 순회하면서 대문자로 전환 가능한거 전환해줌
        System.out.println();
        ns.stream()
                .map(e -> e + "끼얏호우 ") // List 요소에 문자 추가
                .forEach(System.out::print);
        System.out.println();

        // 이중 배열인 경우
        String[][] arr = new String[][] {{"a ","b ","c "},{"1 ","2 ","3"}};
        // 기존에 쓰던
        Arrays.stream(arr) // 배열로 스트림 바로 쓰기!
                .map(e -> Arrays.stream(e))
                .forEach(System.out::print);
        // 주소값이 나와벌임
        System.out.println();
        //변형해서
        Arrays.stream(arr)
                .map(e -> Arrays.stream(e))
                .forEach(r -> r.forEach(System.out::print));
        //forEach 메소드에 람다형 조건식으로 넣어줌으로 해결
        System.out.println();
        // 근데 불편하잖음 그럴때 쓰는게 flatMap 메소드
        Arrays.stream(arr)
                .flatMap(Arrays::stream) // 중첩을 제거하고 Stream<String> 으로 캐스팅 해줌 ~> flattening 이라함
                .forEach(System.out::print);
        System.out.println();
        List<String> alphabet = Arrays.asList("v ","f ","s ","d ","b ","a ");
        alphabet.stream().sorted().forEach(System.out::print);
        // 정렬됨
        System.out.println();
        // 역순으로?
        alphabet.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);
        // Comparator 클래스의 reverseOrder 메소드를 사용하여 내림차순으로 할 수 있음
        System.out.println();
        // skip
        IntStream intStream = IntStream.rangeClosed(1,5);
        intStream.skip(3).forEach(System.out::print);
        // skip 메소드로 앞의 3글자 건너뛰기
        System.out.println();
        // limit
        IntStream intStream1 = IntStream.rangeClosed(1,5);
        intStream1.limit(2).forEach(System.out::print);
        // 앞의 2개만 출력
        System.out.println();
        // peek
        IntStream intStream2 = IntStream.of(1, 2,2,3,4,4,5,5,6,7,8,8,9,10);
        int sum = intStream2.filter(e -> e % 2 == 0)
                .peek(System.out::println)
                .sum();
        System.out.println("짝수의 합계 : " +sum);
        // peek로 순회하면서 filter에 걸린 값을 출력, 이후에 sum 메소드로 해당 숫자 합침
    }
}


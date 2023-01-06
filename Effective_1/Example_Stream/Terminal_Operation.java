package Effective_1.Example_Stream;

import java.util.Arrays;
import java.util.List;

public class Terminal_Operation {
    public static void main(String[] args) {
        // 기본 집계 ~> 숫자 관련 메소드는 대부분 최종 연산자로 작동
        int[] num = new int[]{1,2,3,4,5};

        // 개수
        long count = Arrays.stream(num).count(); // count 메소드가 long 타입만 받아들이나봄
        System.out.println("개수 : "+count);

        //합계
        int sum = Arrays.stream(num).sum();
        System.out.println("개수 : "+sum);

        // 평균
        double average = Arrays.stream(num).average().getAsDouble(); // getAsDouble 로 값 더블로 받음
        System.out.println("평균 : "+average);
        
        // 최대값
        int max = Arrays.stream(num).max().getAsInt(); // 인트로 값 받기
        System.out.println("최대값 " + max);

        // 최소값
        int min = Arrays.stream(num).min().getAsInt();
        System.out.println("최소값 " + min);

        // 배열의 첫 번째 요소 
        int first = Arrays.stream(num).findFirst().getAsInt();
        System.out.println("배열의 첫번째 요소 " + first);

        // 근데 최종 연산자로 끝냈는데 get? 어떻게 들어가지
        // ~>
        // // 평균값을 구해 Optional 객체로 반환
        //        OptionalDouble average = Arrays.stream(intArr).average();
        //        System.out.println(average);
        //
        //        // 기본형으로 변환
        //        double result = average.getAsDouble();
        //        System.out.println("전체 요소의 평균값 " + result);
        // 이게 풀어 쓴거
        // 즉 OptionalDouble 클래스는 래퍼 클래스로 null 값이 나와서 에러가 발생하는 현상을
        // 방지하기 위함
        // 그래서 캐스팅이 한번 더 필요한 것
        // 즉, 객체로 반환된 값을 다시 기본형으로 변환하기 위한 것이라 스트림 파이프라인과는 관계 없음

        boolean result = Arrays.stream(num).allMatch(e -> e % 2 == 0);
        System.out.println(result);
        result = Arrays.stream(num).anyMatch(e -> e % 3 == 0);
        System.out.println(result);
        result = Arrays.stream(num).noneMatch(e -> e % 3 == 0);
        System.out.println(result);
        // boolean 값으로 조건 결과 출력

        // reduce
        long sum1 = Arrays.stream(num).sum();
        System.out.println("전체 요소 합 : "+sum1);

        int sum2 = Arrays.stream(num)
                .reduce((a,b) -> a + b)
                .getAsInt();
        System.out.println("초기 값이 없는 reduce : "+sum2);
        int sum3 = Arrays.stream(num)
                .reduce(5,(a,b) -> a + b);
        System.out.println("초기 값 5가 있는 reduce : "+sum3);
        // a = 누적 값 , b = 새롭게 더해질 값
        // 최초 연산 시에 1+2 -> a:3, b:3
        // 마지막 6+4 -> a: 10, b: 5
        // 그리고 나서 초기값이 더 해짐
    }
}

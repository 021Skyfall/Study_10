package Effective_1.Example_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Create_CollectionStream {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> stream = list.stream();
        // List 클래스를 참조하고 있는 변수 list 에서 곧바로 stream() 메소드를 호출 가능함
        // 이미 Collection 클래스에 stream() 메소드가 정의되어있기 때문
        // 그래서 생성이 간편함
        stream.forEach(System.out::print);

        System.out.println();
        // 무한 스트림
//        IntStream ints = new Random().ints();
//        ints.forEach(System.out::println);
        // 난수 무한 생성
        // 횟수 제한을 두고 싶다면
//        IntStream in = new Random().ints(3);
        IntStream in = new Random().ints().limit(3);
        in.forEach(System.out::println);
        // 2가지의 제한 두는 방법

        // 범위는?
        IntStream out = IntStream.rangeClosed(1,10);
        out.forEach(System.out::println);
    }
}

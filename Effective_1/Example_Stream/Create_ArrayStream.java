package Effective_1.Example_Stream;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Create_ArrayStream {
    public static void main(String[] args) {
        //배열 스트림 생성

        int[] arr = new int[]{1, 2, 3, 4, 5};
        IntStream intStream = Arrays.stream(arr);
        // int 배열을 int 형 스트림으로 생성 후 intStream 에 할당
        intStream.forEach(System.out::print);

        System.out.println();

        double[] arr2 = new double[]{1.1, 1.2, 1.3, 1.4, 1.5};
        // double 배열을 double 형 스트림으로 생성
        DoubleStream doubleStream = Arrays.stream(arr2);
        // double 배열을 double 형 스트림으로 생성
        doubleStream.forEach(System.out::print);

        System.out.println();

        String[] arr1 = new String[]{"Hello", " Java", " World", " !"};
//        Stream<String> stream = Arrays.stream(arr1);
        // String 배열을 String 형 스트림으로 생성
        Stream<String> stream = Stream.of(arr1);
        // 문자열은 스트림 클래스에서 불러온 메소드인 of() 도 가능
        stream.forEach(System.out::print);

        System.out.println();

        char[] arr3 = new char[]{'a','b','c','d','e'};
        Stream<Character> stream1 = new String(arr3)
                .chars().mapToObj(x -> (char) x);
        // Character 는 특이하게 배열을 문자열로 생성한 다음에
        // 다시 String 클래스의 메소드 들로 나누고
        // 해당 클래스의 stream 객체의 메소드인 mapToObj 를 사용해서
        // 다시 다운캐스팅 해 줘야함
        stream1.forEach(System.out::print);

    }
}

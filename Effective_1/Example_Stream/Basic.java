package Effective_1.Example_Stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Basic {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5);

        // 기존의 Iterator 방식 순회
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
        }

        System.out.println();

        // 스트림 사용 순회
        Stream<Integer> stream = list.stream();
        stream.forEach(System.out::print);
    }
}

package Effective_1.Example_Lambda;

public class Method_reference {
    public static void main(String[] args) {
        A a;
        a = Integer :: sum;
        System.out.println(a.ac(1,2));
        a = Integer :: max;
        System.out.println(a.ac(5,1));
        a = Integer :: min;
        System.out.println(a.ac(5,1));
        // 기존 함수형 인터페이스 참조 메소드

        a = Plus :: s; // 클래스명 :: 메소드명
        System.out.println(a.ac(7,1));
        // 정적 메소드 참조

        Plus plus = new Plus();
        a = plus :: i; // 인스턴스명 :: 메소드명
        System.out.println(a.ac(7,1));
        // 인스턴스 메소드 참조
    }
}
interface A { // 함수형 인터페이스
    int ac(int x, int y);
}
class Plus {
    public static int s(int x, int y){ // 정적 메소드
        return x + y;
    }
    public int i(int x, int y) { // 인스턴스 메소드
        return x * y;
    }
}
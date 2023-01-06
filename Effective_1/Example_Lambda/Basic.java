package Effective_1.Example_Lambda;

public class Basic {
    public static void main(String[] args) throws Exception {
//        Object obj = new Object() {
//            int sum(int num1, int num2) {
//                return num1 + num1;
//            }
//        };
//        위는 Object 클래스에 sum 메소드가 없기 때문에
//        Object 클래스를 인스턴스화 해봤자 사용할 수 없음
//        이를 해결하기 위해 함수형 인터페이스 도입
//        ↓
        Functional functional = (num1, num2) -> num1 + num2;
        // 참고로 이거 num 에 int 타입 들어갈거고 래퍼 클래스인 Integer 에
        // 더하기 메소드가 있음 그래서 변형 가능
        // 그래서 Functional functional = Integer::sum; 로 변형 가능

        // Functional 클래스를 참조 타입으로
        // 참조 변수를 선언하고 동시에 람다식으로 sum 추상 메소드를 정의함
        System.out.println(functional.sum(1,2)); 
        // 위 과정을 거쳐 메소드를 사용할 수 있게 됨
        // 그러니까 이게 기존에 하던 인터페이스 사용법이 압축된 형태
        // 단, 1:1로 매칭되어야함

        // 매개 변수와 리턴값이 없는 람다식의 경우 ↓
        Exam2 exam2 = () -> System.out.println("뭐요");
        // 타입이 void 인 경우 말 그대로 공허함
        exam2.ac();

        functional = (num1, num2) -> num1 - num2;
        System.out.println(functional.sum(32,24));
        functional = (num1, num2) -> num1 * num2;
        System.out.println(functional.sum(22,54));
        // 이거 써보니까 연속적으로 재정의 할 수 있네 걍 오버라이딩 되나봄
        // 람다식으로 인터페이스 재정의 즉, 오버라이딩
        // 당연히 오버라이딩 된 것이기 때문에 절차적으로 나오는 거고
        // 결국 return 문만 있으면 기본적으로 쓸 필요가 없고
    }
}
interface Functional {
    int sum (int num1, int num2); // 리턴 값과 매개변수가 있는 경우
}
interface Exam2 {
    void ac(); // 메소드 타입이 void 인 경우
}
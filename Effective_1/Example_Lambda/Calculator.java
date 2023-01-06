package Effective_1.Example_Lambda;

public class Calculator {
    // 람다식을 이용한 간편 계산기
    public static void main(String[] args) {
        Calculable add = (a, b) -> a + b;
        Calculable subtract = (a, b) -> a - b;
        Calculable multiply = (a, b) -> a * b;
        Calculable divide = (a, b) -> a / b;

        operate(add,1,2);
        operate(divide,3,3);

    }
    private static void operate(Calculable calculable, int a, int b) {
        System.out.println(calculable.calcul(a,b));
    }
}
@FunctionalInterface
interface Calculable {
    int calcul(int a, int b);
}
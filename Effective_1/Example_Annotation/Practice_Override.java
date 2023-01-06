package Effective_1.Example_Annotation;

public class Practice_Override {
    public static void main(String[] args) {
        Example ex = new power1();
        ex.exam();
    }
}
interface Example{
    void exam();
}
class power1 implements Example{
    @Override // << 이게 애너테이션 / @로 시작하며 클래스, 인터페이스, 필드, 메서드 등에 붙여서 사용
    // 이거 추상 메소드 구현 오버라이드 입니다~하고 컴파일러에게 알려주는 역할
    public void exam() {
        System.out.println("애너테이션 연습");
    }
}
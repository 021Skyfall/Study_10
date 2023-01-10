package Effective_3;
// Runnable 인터페이스를 구현한 객체에서 run()을 구현하여 스레드를 생성하고 실행하는 방법
public class MultiThreading_1 {
    public static void main(String[] args) {
        // Runnable 인터페이스를 구현한 TreadTask 클래스 인스턴스화
//        Runnable runnable = new ThreadTask1();

        // Runnable 구현 객체를 인자로 전달하면서 Thread 클래스를 인스턴스화하여 스레드 생성
//        Thread thread = new Thread(runnable);

        // 위 압축 ~> Thread 클래스 인스턴스화의 인자로 Runnable 인터페이스를 구현한 ThreadTask1 인스턴스화 전달
        // 결국 의미 자체는 구현한 ThreadTask1 에 있기 때문에 가능한 것
        Thread thread = new Thread(new ThreadTask1());
        thread.start(); // 시작 메소드

        for (int i = 0; i < 100; i++) {
            System.out.print("@");
        }// 메인메소드에 추가
    }
}
class ThreadTask1 implements Runnable { // Runnable 인터페이스 구현
    @Override
    public void run() { // 인터페이스 메소드 오버라이드(구현)
        for (int i = 0; i < 100; i++)
            System.out.print("#");
    }
}
// 출력 결과 =
// 매 출력마다 결과가 달라짐 + @와 #이 섞여서 나오는 경우도 있음
// 이유 =
// 작업 스레드인 Thread 와 메인 스레드인 for~ 구문이 동시에 작동(병렬 구동)하기 때문임
// 이게 멀티 스레딩
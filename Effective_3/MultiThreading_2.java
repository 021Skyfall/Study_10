package Effective_3;
// Thread 클래스를 상속 받은 하위 클래스에서 run()을 구현하여 스레드를 생성하고 실행하는 방법
public class MultiThreading_2 {
    public static void main(String[] args) {
        // 인터페이스인 runnable 을 다룰 때처럼 Thread 클래스를 직접 인스턴스화 안함
        // 상속이니까 뭐 어차피 하위 객체인 ThreadTask2 가 Thread 를 참조하고 있는거는 뻔해서
        // 왜냐고? 자바는 다중 상속이 불가능하거든요
        // 인터페이스는 왜 그러냐고? 다중 구현이 가능하기 때문에 콕 찝어줘야지요
        ThreadTask2 task2 = new ThreadTask2();
        task2.start(); // 소환!!!!!!!!!

        for (int i = 0; i < 100; i++) {
            System.out.print("*");
        } // 메인 스레드 실행
    }
}
class ThreadTask2 extends Thread {
    @Override
    public void run() { // 메소드 오버라이드
        for (int i = 0; i < 100; i++) {
            System.out.print("!");
        }
    }
}
// 결과는 구현했던 전 단계와 마찬가지로 섞여서 나오기도하고 아니기도하고
// 병렬 구동 가능
package Effective_3;
// 익명 객체를 사용하여 스레드 생성하고 실행하기
public class MultiThreading_3 {
    public static void main(String[] args) {
        // 일회용 익명 객체 구현 / runnable 구현 객체 / 인터페이스
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    System.out.print("1");
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    System.out.print("3");
                }
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    System.out.print("4");
                }
            }
        });
        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    System.out.print("5");
                }
            }
        });
        // Thread 익명 하위 객체 활용 / Thread 바로 호출
        Thread thread = new Thread() {
            public void run() {
                for (int i = 0; i < 30; i++) {
                    System.out.print("!");
                }
            }
        };

        // 익명 구현 객체 람다식 ~> 익명 하위 객체 문법 같음
        Thread thread5 = new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                System.out.print("*");
            }
        });


        thread1.start();
        thread2.start();
        thread4.start();
        thread3.start();
        thread.start();
        thread5.start();

            for (int i = 0; i < 30; i++) {
                System.out.print("2");
            }
    }
}

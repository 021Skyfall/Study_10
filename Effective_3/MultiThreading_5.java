package Effective_3;

public class MultiThreading_5 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                while (true) Thread.sleep(1000);
            } catch (Exception e) {}
                System.out.println("Wake up!");
        });
        System.out.println("thread1.getState() = " + thread1.getState());
        thread1.start(); // 대기 상태
        System.out.println("thread1.getState() = " + thread1.getState());

        while (true) {
            if (thread1.getState() == Thread.State.TIMED_WAITING) {
                System.out.println("thread1.getState() = " + thread1.getState());
                break;
            }
        }
        thread1.interrupt(); // 스레드 강제 실행
        while (true) {
            if (thread1.getState() == Thread.State.RUNNABLE) {
                System.out.println("thread1.getState() = " + thread1.getState());
                break;
            }
        }
        while (true) {
            if (thread1.getState() == Thread.State.TERMINATED) {
                System.out.println("thread1.getState() = " + thread1.getState());
                break;
            }
        }
    }
}

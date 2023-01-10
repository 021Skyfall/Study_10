package Effective_3;
//스레드A가 공유 객체에 자신의 작업을 완료합니다.
//이 때, 스레드B와 교대하기 위해 notify()를 호출합니다.
//notify()가 호출되면 스레드B가 실행 대기 상태가 되며, 곧 실행됩니다.
//이어서 스레드A는 wait()을 호출하며 자기 자신을 일시 정지 상태로 만듭니다.
//
//이후 스레드B가 작업을 완료하면 notify()를 호출하여 작업을 중단하고 있던 스레드A를 다시 실행 대기 상태로 복귀시킨 후,
//wait()을 호출하여 자기 자신의 상태를 일시 정지 상태로 전환합니다.
//
//이와 같은 과정이 반복되면서,
//두 스레드는 공유 객체에 대해 서로 배타적으로 접근하면서도 효과적으로 협업할 수 있습니다.

public class MultiThreading_7 {
    public static void main(String[] args) {
        WorkObject sharedObject = new WorkObject();
        ThreadA threadA = new ThreadA(sharedObject);
        ThreadB threadB = new ThreadB(sharedObject);

        threadA.start();
        threadB.start();

    }
}
class WorkObject { // 메소드 동기화는 하나씩만 실행되게하려고 검
    public synchronized void methodA() { // 1. 먼저 인자로 받은 스레드 실행 / 9. 교대된 스레드 실행 ~ 반복
        System.out.println("ThreadA의 methodA 작업 중"); // 2. 실행
        notify(); // 3. 교대
        try {wait();} catch (Exception e) {} // 4. 자기는 일시정지 상태로
    }
    public synchronized void methodB() { // 5. 교체된 스레드 실행
        System.out.println("ThreadB의 methodB 작업 중"); // 6. 실행
        notify(); // 7. 교대
        try {wait();} catch (Exception e) {} // 8. 자신은 일시정지
    }
}
// 아래 객체를 실행하고서 끝나지 않는 이유는 위의 wait 메소드로 정시 시켰기 때문임
class ThreadA extends Thread {
    private WorkObject workObject; // 캡슐화

    public ThreadA(WorkObject workObject) {
        this.workObject = workObject;
    } // 인자 받아올 생성자

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) { // 실행될 횟수
            workObject.methodA();
        }
    }
}

class ThreadB extends Thread {
    private WorkObject workObject;

    public ThreadB(WorkObject workObject) {
        this.workObject = workObject;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            workObject.methodB();
        }
    }
}


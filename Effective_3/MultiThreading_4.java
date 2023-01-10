package Effective_3;

public class MultiThreading_4 {
    public static void main(String[] args) {
        Runnable runnable = new TreadTask();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.setName("김씨");
        thread2.setName("박씨");

        thread1.start();
        thread2.start();
    }
}
class Accout {
    private int balance = 1000; // 잔액

    public int getBalance() {
        return balance;
    }

    //인출 성공 실패 boolean 으로 반환
//    public synchronized boolean withDraw(int money) { // << 메소드 전체를 임계 영역 설정
    public boolean withDraw(int money) {
        synchronized (this) { // << 특정 영역을 임계 영역 설정
            //인출 가능 여부 판단
            if (balance >= money) {
                //if 문에 진입하자마자 해당 스레드 정지 후
                // 다른 스레드로 제어권 강제 변경
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }

                // 잔액에서 인출금을 깎아 새로운 잔액 기록
                balance -= money;

                return true;
            }
            return false;
        } // 임계 영역으로 지정해야함 ~> synchronized // 여기까지 임계 영역
    }
}
class TreadTask implements Runnable {
    Accout accout = new Accout();

    @Override
    public void run() {
        while (accout.getBalance() > 0) {

            //100~300 원 사이로 인출금 랜점 지정
            int money = (int)(Math.random()*3+1) * 100;

            //withDraw 를 실행시키는 동시에 인출 성공 여부 변수에 할당
            boolean denied = !accout.withDraw(money);

            // 인출 결과 확인
            // withDraw 가 false 리턴하면 DENIED 출력
            System.out.println(String.format("WithDraw %d원 by %s. Balance : %d %s",
                    money,Thread.currentThread().getName(),accout.getBalance(),denied ? "-> DENIED" : ""));

        }
    }
}
// 잔액 출력 값이 이상하게 나옴
// 두 스레드 간에 객체가 공유되기 때문에 발생하는 오류
// 조건문 무시하고 음수 잔액 한번 씩 발생
// 음수는 ~> Account 객체를 공유하는 상황에서 한 스레드가 if 조건문을 true로 받는 동안
// 또 다른 스레드가 끼어든 것 << 얘는 false 인거지 원래
// DENIED 도 나왔다가 안나왔다가 함
// 임계 영역 설정 후
// 스레드가 하나씩 번갈아 withDraw 에 들어가며 처리됨
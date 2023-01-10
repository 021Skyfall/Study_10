package Effective_3;

public class MultiThreading_6 {
    public static void main(String[] args) {
        SumThread sumThread = new SumThread();
        sumThread.setTo(10);
        sumThread.start();


        // 메인 스레드가 sumThread의 작업이 끝날 때 까지 기다림
        try {sumThread.join();} catch (Exception e){}
        // 아 이거 끄고 실행 시키니까
        // 당장에 메인 메소드가 먼저 실행되서
        // sumThread 의 run() 메소드 안에서 이뤄지는 작업이 안끝나고 바로 출력되버려서
        // 합이 0 으로 나옴 ㅋㅋ

        System.out.println(String.format("1부터 %d까지의 합 = %d"
        , sumThread.getTo(),sumThread.getSum()));
    }
}
class SumThread extends Thread {
    private long sum;
    private int to;

    public long getSum() {
        return sum;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    @Override
    public void run() {
        for (int i = 1; i <= to; i++){
            sum += i;
        }
    }
}

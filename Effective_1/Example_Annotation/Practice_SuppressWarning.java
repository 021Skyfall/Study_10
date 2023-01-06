package Effective_1.Example_Annotation;

public class Practice_SuppressWarning {
    public static void main(String[] args) {
        Anno anno = new Anno();
        anno.aa1();
    }
}
class Anno {
    @SuppressWarnings("all")
    public void aa1() {
        if(0==0) { // << always true 라는 경고가 출력 안됨
            System.out.println("무조건 true임");
        } else System.out.println("이건 무조건 안나옴");
    }
}
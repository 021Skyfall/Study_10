package Effective_1.Example_Annotation;

public class Practice_Deprecated {
    public static void main(String[] args) {
        OldClass oldClass = new OldClass();
        System.out.println(oldClass.getOldField()); // << 밑줄로 경고해줌
    }
}
class OldClass {
    @Deprecated // 삭제하기 곤란해 남겨야하지만 쓰는 거 권장하지 않음의 뜻
    private int oldField;

    @Deprecated
    public int getOldField() {
        return oldField;
    }
}
package Effective_1.Example_Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public class Practice_Target {
}
@Target({ElementType.FIELD,ElementType.TYPE,ElementType.TYPE_USE}) // 얘네를 담고 있는
@interface Custom{} // 커스텀 애노테이션 생성
@Custom // Type 대상에 적용
class main {
    @Custom // FIELD 대상에 적용
    int i;
}

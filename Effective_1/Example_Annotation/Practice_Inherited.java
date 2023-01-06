package Effective_1.Example_Annotation;

import java.lang.annotation.Inherited;

@Inherited
@interface Super{} // 인헤릿 메타 애노테이션 생성
@Super // 적용 ~> 하위 클래스까지 적용되는 것
public class Practice_Inherited {
}

class sub extends Practice_Inherited{} // 그러므로 @Super 가 붙은 것으로 인식
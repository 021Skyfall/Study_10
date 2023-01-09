package Effective_1.Steam_Quest;

import java.util.List;

public class a_computeAverageOfMaleMember {
    //Member 클래스를 이용해 회원의 이름, 성별, 나이까지 관리하려고 합니다.
    // Member 타입을 요소로 가지는 List를 입력받아, 남성 회원들의 평균 나이를 리턴해야 합니다.
    public double computeAverageOfMaleMember(List<Member> members) {
        double result = members.stream() // 스트림화
                .filter(e -> e.getGender().equals("Male")) // 입력받는 매개변수 인자 중 gender가 Male 인것만 필터링
                .mapToDouble(Member::getAge) // 앞선 filter 에서 걸러진 male 의 age 값을 더블로 변경
                .average() // 더블로 변경한 해당 age 값의 평균
                .orElse(0); // 일련의 과정을 거친 후 filter 에서 걸러진 애들 제외하고는 0 출력
                                  // 그러니까 위에 해당 사항 없는 것들 전부 0으로 둔다는 뜻
//        아 이거 orElse 가 Optional~ 타입에서 쓸 수 있는 메소드래
//        이 말은 즉슨 계산형인 average 는 타입이 Optional 타입으로 바뀌고
//        이 옵셔널 타입은 옵셔널 클래스고 그 클래스에 orElse 라는 if 문 대체 메소드가 있는 것
        return result;
    }

    // 아래 코드는 변경하지 마세요.
    static class Member {
        String name;
        String gender;
        int age;

        public Member(String name, String gender, int age) {
            this.name = name;
            this.gender = gender;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getGender() {
            return gender;
        }

        public int getAge() {
            return age;
        }
    }
}

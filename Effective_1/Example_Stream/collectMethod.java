package Effective_1.Example_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class collectMethod {
    public static void main(String[] args) {
        List<Person> list = Arrays.asList(
                new Person("김씨",32,Person.Gender.Male,"aa"),
                new Person("이씨",28,Person.Gender.Female,"bb"),
                new Person("박씨",33,Person.Gender.Male,"cc"),
                new Person("최씨",38,Person.Gender.Male,"dd")
        );
        Map<String,Integer> male = list.stream()
                .filter(e -> e.getGender() == Person.Gender.Male)
                .collect(Collectors.toMap(
                        p -> p.getName(),
                        p -> p.getAge()
                ));
        System.out.println(male);
        // Person 클래스에 객체 생성 후 List 에 때려박고
        // 이름과 나이 두 가지를 받아오기 위해
        // 키와 값으로 나뉘는 Map 으로 반환
        // 이후 Map 에 filer 로 객체의 enum 이 Male 인 객체만 거름
        // collect 로 list 의 배열을 Map 형태로 변환 후 Name 과 Age 만 getter 로 읽어옴
        // 그럼 collect 로 주서 담은 객체는 male 로 들어감
        // 그래서 male 을 출력하면 걸러진 결과가 나옴
        // 한 박스에 객체가 두 개 라 가능한듯? 성별은 enum 으로 넣었고
        // Person 에 멤버 몇 개를 만들던 상관은 없는데
        // collector 로 담는건 Map 타입이라 두 개 밖에 안되네
        // 흠.. 근데 어떻게 쓰는지 정확히 모르는듯 Collection 으로 한 객체만 뽑아와보려고했는데 흠...
    }
}
class Person {
    public enum Gender {Male,Female}
    private String name;
    private int age;
    private Gender gender;
    private String middleName;

    public Person(String name, int age, Gender gender, String middleName) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.middleName = middleName;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public String getMiddleName() {
        return middleName;
    }
}

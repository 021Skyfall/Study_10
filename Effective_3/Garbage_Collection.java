package Effective_3;

public class Garbage_Collection {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("김씨");
        person = null;
        // person 변수가 null 값으로 없는 걸로 바꾸었기 때문에
        // 해당 person 변수는 더 이상 Person 인스턴스와 연결되어있지 않음
        // 즉 쓰지 않는 변수라는 것
        // 이게 가비지 발생
        // 자바서는 가비지가 발생함과 동시에 메모리에서 삭제 해줌
        person = new Person();
        person.setName("박씨");

        System.out.println(person.getName());
    }
}
class Person {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
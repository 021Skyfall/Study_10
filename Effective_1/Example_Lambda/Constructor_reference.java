package Effective_1.Example_Lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Constructor_reference {
    public static void main(String[] args) {
        Function<String,Person> function = Person::new;
        Person person = function.apply("");
        BiFunction<String,String,Person> biFunction = Person::new;
        Person person1 = biFunction.apply("","");

    }
}
class Person {
    private String name;
    private String id;

    public Person(String name) {
        this.name = name;
        System.out.println("이름만");
    }

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
        System.out.println("이름 아이디");
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}

//이거 근데 잘 이해 안감
//Function 이랑 BiFunction 들어가는 이유랑
//왜 써야하는지?
//람다식이 맞는지? 맞다면 인터페이스는 어따 팔아먹었는지?
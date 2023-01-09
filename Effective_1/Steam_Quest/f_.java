package Effective_1.Steam_Quest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class f_ {
    public List<String> findPeople(List<String> male, List<String> female, String lastName) {
        //TODO..
        List<String> a = male.stream().filter(e -> e.startsWith(lastName))
                .collect(Collectors.toList());
        List<String> b = female.stream().filter(e->e.startsWith(lastName))
                .collect(Collectors.toList());
        return Stream.concat(a.stream(),b.stream()).sorted().distinct().collect(Collectors.toList());


    }
}

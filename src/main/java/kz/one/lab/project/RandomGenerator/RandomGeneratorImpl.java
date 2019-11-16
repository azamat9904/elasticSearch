package kz.one.lab.project.RandomGenerator;

import kz.one.lab.project.Entity.Person;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Slf4j
@Component
@Getter
@Setter
public class RandomGeneratorImpl implements RandomGenerator {

    @Override
    public List<Person> generateUser(int size) {
        List<Person> persons = new LinkedList<>();
        for(int i=0;i<size;i++){
            persons.add(new Person(generateName(),generateAge()));
        }
        return persons;
    }

    @Override
    public List<Integer> generateNumber(int size){
        List<Integer> numbers = new LinkedList<>();
        for(int i=0;i<size;i++){
            Random random = new Random();
            numbers.add(random.nextInt(4)+1);
        }
        return numbers;
    }

    private String generateName()  {
        Random rnd = new Random();
        String name = "";
        for(int j=0;j<10;j++) {
            char symbol = (char)(rnd.nextInt(26) + 65);
            name += symbol + "";
        }
        return name;
    }

    private Integer generateAge() {
        Random random = new Random();
        int age = random.nextInt(100) + 1;
        return age;
    }

}


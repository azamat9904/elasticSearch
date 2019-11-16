package kz.one.lab.project.RandomGenerator;

import kz.one.lab.project.Entity.Person;

import java.util.List;

public interface RandomGenerator {
    List<Person> generateUser(int size);
    List<Integer> generateNumber(int size);
}

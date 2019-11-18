package kz.one.lab.project.Controller;

import io.swagger.annotations.ApiOperation;
import kz.one.lab.project.Entity.Person;
import kz.one.lab.project.Entity.Phone;
import kz.one.lab.project.PersonRepository.PersonRepository;
import kz.one.lab.project.PersonRepository.PhoneRepository;
import kz.one.lab.project.RandomGenerator.RandomGeneratorImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("onelab")
@Slf4j
@Qualifier("personRestController")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    RandomGeneratorImpl randomGenerator;

    @Autowired
    PhoneRepository phoneRepository;

    @ApiOperation("save Persons")
    @RequestMapping(value = "/persons/",method = RequestMethod.POST)
    public Person save(@RequestParam String name,@RequestParam int age){
        Person person = new Person(name,age);
        personRepository.save(person);
        log.info("добавлен пользователь " + person + " в бд");
        return person;
    }

    @ApiOperation("Get Persons by name")
    @GetMapping(value = "/getPersonByName/",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> getPersonByName(@RequestParam String name){
        List<Person> persons = personRepository.findAllByName(name);
        return persons;
    }

    @ApiOperation("Get Persons by age")
    @GetMapping(value = "/getPersonByAgeBetween/",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> getPersonByAge(@RequestParam int start ,@RequestParam int end){
        List<Person> persons = personRepository.findAllByAgeBetween(start,end);
        return persons;
    }

    @ApiOperation("Get Persons by Name and Age")
    @GetMapping(value = "/getPersonByNameAndAge/" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> getPersonByNameAndAge(@RequestParam int age,@RequestParam String name){
        List<Person> persons = personRepository.findAllByNameAndAge(name,age);
        return persons;
    }

    @ApiOperation("Generate persons and numbers of Phone")
    @PutMapping(value = "/generateUsers/")
    public void generateUsers(){
        long start = System.currentTimeMillis();
        List<Person> persons = randomGenerator.generateUser(100);
        List<Integer> numbers = randomGenerator.generateNumber(100);
        for(int i=0;i<100;i++){
            personRepository.save(persons.get(i));
            phoneRepository.save(new Phone(numbers.get(i)));
        }
        long end = System.currentTimeMillis();
        log.info("Time wasted for execution in ms " + (end-start));
    }

    @ApiOperation("EndPoint ,get Time for Execution")
    @GetMapping(value = "/getTime/" , produces = MediaType.APPLICATION_JSON_VALUE)
    public long getTime(){
        long start = System.currentTimeMillis();
        List<Person> persons = personRepository.findAll();
        List<Phone> phone = phoneRepository.findAll();
        long end = System.currentTimeMillis();
        return (end-start);
    }

}

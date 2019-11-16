package kz.one.lab.project.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.stereotype.Component;
import javax.persistence.*;

@Component
@Getter
@Setter
@Entity
@Document(indexName = "my_index", type = "user")
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;
    private Person(){}
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return this.name + " " + this.age;
    }

}

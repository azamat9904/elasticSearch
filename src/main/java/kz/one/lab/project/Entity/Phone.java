package kz.one.lab.project.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Component
public class Phone {
    @Id
    @GeneratedValue
    private Long id;
    private Integer number;

    public Phone(){}
    public Phone(Integer number){
        this.number = number;
    }

    public String toString(){
        return id + " " + number;
    }

}

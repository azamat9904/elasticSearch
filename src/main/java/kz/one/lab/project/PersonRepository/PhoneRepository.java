package kz.one.lab.project.PersonRepository;

import kz.one.lab.project.Entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone,Long> {
    List<Phone> findAll();
}

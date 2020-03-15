package me.rn00n.WebMvcConfigurer.DomainClassConverter;

import me.rn00n.WebMvcConfigurer.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}

package org.example.springendava.ch3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.springendava.ch3")
public class ProjectConfig {

//    @Bean
//    public Parrot parrot() {
//        Parrot parrot = new Parrot();
//        parrot.setName("Koko");
//        return parrot;
//    }
//
//    @Bean
//    public Person person() {
//        Person person = new Person();
//        person.setName("Bilo");
//        person.setParrot(parrot());
//        return person;
//    }
//
//
//
//    @Bean
//    public Person person(Parrot parrot) {
//        Person person = new Person();
//        person.setName("Bilo");
//        person.setParrot(parrot);
//        return person;
//    }

}

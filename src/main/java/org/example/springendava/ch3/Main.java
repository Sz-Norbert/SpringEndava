package org.example.springendava.ch3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

   public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext
                (ProjectConfig.class);

        Person person =
                context.getBean(Person.class);

        Parrot parrot =
                context.getBean(Parrot.class);

        System.out.println(
                "Person's name: " + person.getName());

        System.out.println(
                "Parrot's name: " + parrot.getName());

        System.out.println(
                "Person's parrot: " + person.getParrot());

        var context2 = new AnnotationConfigApplicationContext
                (ProjectConfig.class);

        Person p = context2.getBean(Person.class);

        System.out.println("Person's name: " + p.getName());
        System.out.println("Person's parrot: " + p.getParrot());

    }

}

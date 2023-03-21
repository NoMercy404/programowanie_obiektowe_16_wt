package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Person implements Serializable {
    private String name;
    private LocalDate birth, death;
    private Person parents[] = new Person[2];
    private String path = null;

    private static List<Person> people = new ArrayList<Person>();
    public Person(String name, LocalDate birth) {
        this(name, birth, null);
        people.add(this);
    }

    public Person(String name, LocalDate birth, LocalDate death) {
        this.name = name;
        this.birth = birth;
        this.death = death;
        try {
            people.add(this);
            if (birth.isAfter(death)) {
                throw new NegativeLifespanException(birth, death, "Possible time-space loophole.");
            }
        } catch (NullPointerException e) {}
    }

    public Person(String name, LocalDate birth, LocalDate death, Person parent1, Person parent2) throws IncestException {
        this(name, birth, death);
        parents[0] = parent1;
        parents[1] = parent2;
        checkForIncest();
    }

    public Person(String name, LocalDate birth, Person parent1, Person parent2) throws IncestException {
        this(name, birth, null, parent1, parent2);
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static Person getPersonByName(String name) {
        for(Person person:people){
            if(person.name.equals(name)){
                return person;
            }
        }

        return null;
    }

    public static Person buildPerson(String path) throws FileNotFoundException, AmbigiousPersonException, IncestException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        String name = scanner.nextLine();
        LocalDate birth =  LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        LocalDate death = null;
        Person parent1 = null;
        Person parent2 = null;

        if(scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(!line.equals("Rodzice:")) {
                death = LocalDate.parse(line, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                if(scanner.hasNextLine()) {
                    line = scanner.nextLine();
                }
            }
            if(line.equals("Rodzice:")) {
                line = scanner.nextLine();
                parent1 = Person.getPersonByName(line);
                if(scanner.hasNextLine()) {
                    line = scanner.nextLine();
                   parent2 = Person.getPersonByName(line);
                }
            }
        }

        for(Person person:people){
            if(person.name.equals(name)){
                throw new AmbigiousPersonException(name, path, person.path);
            }
        }
        Person person = new Person(name,birth,death,parent1,parent2);
        person.setPath(path);
        return person;
    }

    public static List<Person> buildPeople(List<String> paths) throws FileNotFoundException, AmbigiousPersonException {
        List<Person> people = new ArrayList<>();

        for (var path : paths){
            people.add(Person.buildPerson(path));
        }

        return people;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birth=" + birth +
                ", death=" + death +
                ", parents=" + Arrays.toString(parents) +
                '}';
    }

    void checkForIncest() throws IncestException {
        if(parents[0] == null || parents[1] == null)
            return;
        for(var leftSideParent : parents[0].parents) {
            if (leftSideParent == null) continue;
            for (var rightSideParent : parents[1].parents) {
                if (rightSideParent == null) continue;
                if (leftSideParent == rightSideParent)
                    throw new IncestException(leftSideParent, this);
            }
        }
    }
}
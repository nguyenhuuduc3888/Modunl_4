package all.service;

import all.model.Person;

import java.util.List;

public interface IPersonService {
    String[] getDayOfBirth();

    String[] getTravel();

    String[] getDay();

    void update(int id, Person person);

    Person findById(int id);

    List<Person> findALL();

    public void save(Person person);
}

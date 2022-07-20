package all.repository;

import all.model.Person;

import java.util.List;

public interface IPersonRepository {
    List<Person> getData();

    String[] getDayOfBirth();

    String[] getTravel();

    String[] getDay();


}
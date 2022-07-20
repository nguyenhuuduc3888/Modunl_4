package all.service;

import all.model.Person;
import all.repository.IPersonRepository;
import all.repository.PersonRepository;

import java.util.List;

public class PersonService implements IPersonService {

    IPersonRepository personRepository = new PersonRepository();
    List<Person> personList = personRepository.getData();

    @Override
    public String[] getDayOfBirth() {
        return personRepository.getDayOfBirth();
    }

    @Override
    public String[] getTravel() {
        return personRepository.getTravel();
    }


    @Override
    public String[] getDay() {
        return personRepository.getDay();
    }

    public void update(int id, Person person) {
        Person updatePerson = findById(id);
        updatePerson.setName(person.getName());
        updatePerson.setDayOfBirth(person.getDayOfBirth());
        updatePerson.setTravelInformation(person.getTravelInformation());
        updatePerson.setStartDay(person.getStartDay());
        updatePerson.setEndDay(person.getEndDay());
        updatePerson.setGoDay(person.getGoDay());
    }

    @Override
    public Person findById(int id) {
        for (Person person : personList) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    @Override
    public List<Person> findALL() {
        return personList;
    }

    @Override
    public void save(Person person) {
        personList.add(person);
    }
}

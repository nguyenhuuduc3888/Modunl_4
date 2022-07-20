package all.repository;

import all.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository implements IPersonRepository {

    static List<Person> personList = new ArrayList<>();

    static {
        personList.add(new Person(1, "Duc", "12/12/2021", "Tau bay", "1", "2", "da nang"));
        personList.add(new Person(2, "quang ", "12/12/2021", "Tau bay", "1", "2", "da nang"));
        personList.add(new Person(3, "code gym", "12/12/2021", "Tau bay", "1", "2", "da nang"));
        personList.add(new Person(4, "hau", "12/12/2021", "Tau bay", "1", "2", "da nang"));
    }


    String[] dayOfBirth = {"13/09/1997", "12/10/2000", "09/02/1994"};
    String[] travel = {"tau bay", "tau thuyen", "o to", "khac"};
    String[] day = {"1", "2", "3", "4", "5"};

    @Override
    public List<Person> getData() {
        return personList;
    }

    @Override
    public String[] getDayOfBirth() {
        return dayOfBirth;
    }

    @Override
    public String[] getTravel() {
        return travel;
    }

    @Override
    public String[] getDay() {
        return day;
    }
}

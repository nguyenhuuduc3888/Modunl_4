package all.service;

import all.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonService {
    @Autowired
    IPersonRepository personRepository;

    @Override
    public String[] getDayOfBirth() {
        return personRepository.getDayOfBirth();
    }

    @Override
    public String[] getGender() {
        return personRepository.getGender();
    }

    @Override
    public String[] getCountry() {
        return personRepository.getCountry();
    }

    @Override
    public String[] getDay() {
        return personRepository.getDay();
    }

    @Override
    public String[] getMonth() {
        return personRepository.getMonth();
    }

    @Override
    public String[] getYear() {
        return personRepository.getYear();
    }

    @Override
    public String[] getTravel() {
        return personRepository.getTravel();
    }
}

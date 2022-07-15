package all.repository;

import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository implements IPersonRepository {
    @Override
    public String[] getDayOfBirth() {
        String[] dayOfBirth = {"13/09/1997", "02/08/1997", "04/08/2002", "09/12/1992"};
        return dayOfBirth;
    }

    @Override
    public String[] getGender() {
        String[] gender = {"Nam", "Nu", "khac"};
        return gender;
    }

    @Override
    public String[] getCountry() {
        String[] country = {"Viet Nam", "China", "Usa", "Korea"};
        return country;
    }

    @Override
    public String[] getDay() {
        String[] day = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "3", "17", "18", "19",
                "20", "21", "22", "23", "24", "25", "26", "27", "28",
                "29", "30", "31"};
        return day;
    }

    @Override
    public String[] getMonth() {
        String[] month = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        return month;
    }

    @Override
    public String[] getYear() {
        String[] year = {"2019", "2020", "2021", "2022"};
        return year;
    }

    @Override
    public String[] getTravel() {
        String[] travel = {"Tau bay", "Tau thuyen", "O to", "Khac"};
        return travel;
    }
}

package all.model;

public class Person {
    private int id;
    private String name;
    private String dayOfBirth;
    private String travelInformation;
    private String startDay;
    private String endDay;
    private String goDay;

    public Person() {
    }

    public Person(int id, String name, String dayOfBirth, String travelInformation, String startDay, String endDay, String goDay) {
        this.id = id;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.travelInformation = travelInformation;
        this.startDay = startDay;
        this.endDay = endDay;
        this.goDay = goDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getTravelInformation() {
        return travelInformation;
    }

    public void setTravelInformation(String travelInformation) {
        this.travelInformation = travelInformation;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getGoDay() {
        return goDay;
    }

    public void setGoDay(String goDay) {
        this.goDay = goDay;
    }
}

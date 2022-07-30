package all.dto;

import all.model.employee.Division;
import all.model.employee.EducationDegree;
import all.model.employee.Position;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EmployeeDto {
    private int id;
    @NotBlank(message = "Khong duoc de trong")
    private String name;
    @NotBlank(message = "Khong duoc de trong")
    private String dateOfBirth;
    @NotBlank(message = "Khong duoc de trong")
    private String idCard;
    @NotNull(message = "Khong duoc de trong")
    private Double salary;
    @NotBlank(message = "Khong duoc de trong")
    private String phone;
    @NotBlank(message = "Khong duoc de trong")
    private String email;
    @NotBlank(message = "Khong duoc de trong")
    private String address;
    private Position position;
    private EducationDegree educationDegree;
    private Division division;



    public EmployeeDto() {
    }

    public EmployeeDto(int id, String name, String dateOfBirth, String idCard, Double salary, String phone, String email, String address, Position position, EducationDegree educationDegree, Division division) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }
}

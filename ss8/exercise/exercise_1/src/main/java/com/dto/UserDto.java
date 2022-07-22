package com.dto;


import javax.validation.constraints.*;

public class UserDto {

    private int id;

    @NotEmpty(message = "First name khong duoc de trong")
    @Size(min = 5, max = 45, message = "it nhat 5 ki tu -- nhieu nhat 45 ky tu")
    private String firstName;

    @NotEmpty(message = "Last name khong duoc de trong")
    @Size(min = 5, max = 45, message = "it nhat 5 ki tu -- nhieu nhat 45 ki tu")
    private String lastName;

    @NotEmpty(message = "Phone khong duoc de trong")
    @Size(max = 11, message = "nhap toi da 10 so")
    @Pattern(regexp = "^0\\d{9}$", message = "sai dinh dang--chi duoc nhap so")
    private String phone;

    @NotNull( message = "Khong duoc de trong")
    @Min(value = 18, message = "tuoi phai lon hon 18")
    @Max(value = 100, message = "tuoi nho hon 100")
    private Integer age;

    @NotEmpty(message = "Email khong duoc de trong")
    @Email(message = "Email sai dinh dang vi du:nguyenhuuduc@gmail12.com", regexp = "^\\w+([.-]?\\w+)*@[a-z]+\\.(\\w+){2,}(\\.\\w{2,3})?")
    private String email;

    public UserDto() {
    }

    public UserDto(int id, String firstName, String lastName, String phone, Integer age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


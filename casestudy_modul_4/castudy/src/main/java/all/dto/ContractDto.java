package all.dto;

import all.model.customer.Customer;
import all.model.employee.Employee;
import all.model.facility.Facility;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ContractDto {
    private int id;
    @NotBlank(message = "Không được để trống ")
    private String dayStart;
    @NotBlank(message = "Không được để trống ")
    private String dayEnd;
    @NotNull(message = "Không được để trống ")
    private Double deposit;
    private Employee employee;
    private Customer customer;
    private Facility facility;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public ContractDto() {
    }

    public ContractDto(int id, String dayStart, String dayEnd, Double deposit) {
        this.id = id;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.deposit = deposit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDayStart() {
        return dayStart;
    }

    public void setDayStart(String dayStart) {
        this.dayStart = dayStart;
    }

    public String getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(String dayEnd) {
        this.dayEnd = dayEnd;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }
}

package all.model;

import javax.persistence.*;

@Entity
public class Oder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer bookCode;

    public Oder() {
    }

    public Oder(Integer id, Integer bookCode) {
        this.id = id;
        this.bookCode = bookCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookCode() {
        return bookCode;
    }

    public void setBookCode(Integer bookCode) {
        this.bookCode = bookCode;
    }
}

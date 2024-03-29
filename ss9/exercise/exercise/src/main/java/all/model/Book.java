package all.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String author;
    private Integer amount;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "bookAndOder",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "oder_id")
    )
    List<Oder> oderList;

    public Book() {
    }

    public Book(Integer id, String name, String author, Integer amount, List<Oder> oderList) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.amount = amount;
        this.oderList = oderList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public List<Oder> getOderList() {
        return oderList;
    }

    public void setOderList(List<Oder> oderList) {
        this.oderList = oderList;
    }
}

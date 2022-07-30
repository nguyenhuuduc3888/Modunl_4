package all.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String blogName;
    private String blogDetail;
    private String blogRent;

    public Blog() {
    }

    public Blog(int id, String blogName, String blogDetail, String blogRent) {
        this.id = id;
        this.blogName = blogName;
        this.blogDetail = blogDetail;
        this.blogRent = blogRent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getBlogDetail() {
        return blogDetail;
    }

    public void setBlogDetail(String blogDetail) {
        this.blogDetail = blogDetail;
    }

    public String getBlogRent() {
        return blogRent;
    }

    public void setBlogRent(String blogRent) {
        this.blogRent = blogRent;
    }
}

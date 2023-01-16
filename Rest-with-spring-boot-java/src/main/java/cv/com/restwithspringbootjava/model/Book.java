package cv.com.restwithspringbootjava.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "book")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long key;
    @Column(name = "author")
    private String author;
    @Column(name = "launch_date", nullable = false)
    private String launchDate;
    @Column(nullable = false, length = 100)
    private Double price;
    private String title;

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return key.equals(book.key);
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + key +
                ", author='" + author + '\'' +
                ", launchDate='" + launchDate + '\'' +
                ", price=" + price +
                ", title='" + title + '\'' +
                '}';
    }
}

package cv.com.restwithspringbootjava.data.dto.v1;

import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class BookDto extends RepresentationModel<BookDto> implements Serializable {
    private Long key;
    private String author;
    private LocalDateTime launchDate;
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

    public LocalDateTime getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(LocalDateTime launchDate) {
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
        if (!super.equals(o)) return false;

        BookDto bookDto = (BookDto) o;

        return Objects.equals(key, bookDto.key);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (key != null ? key.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "key=" + key +
                ", author='" + author + '\'' +
                ", launchDate='" + launchDate + '\'' +
                ", price=" + price +
                ", title='" + title + '\'' +
                '}';
    }
}

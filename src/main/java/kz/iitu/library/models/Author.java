package kz.iitu.library.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Author(String name){
        this.name = name;
    }
    @ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Book> books;

    public Author() {
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }

    public String getName() {
        return name;
    }
}

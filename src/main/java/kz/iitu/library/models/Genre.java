package kz.iitu.library.models;

import javax.persistence.*;
import java.util.List;

@Entity

@Table(name = "genre")
public class Genre{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "genres", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Book> books;

    public Genre(String name){
        this.name = name;
    }

    public Genre() {
    }


    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}

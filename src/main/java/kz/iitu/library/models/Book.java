package kz.iitu.library.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "books")
@ApiModel(description = "Details about the book")
public class Book {
    @ApiModelProperty(notes = "This book Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(notes = "This book Title")
    private String title;

    @ApiModelProperty(notes = "This book genres")
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "book_genres",
            joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "genre_id", referencedColumnName = "id")})
    private List<Genre> genres;

    @ApiModelProperty(notes = "This book authors")
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "book_authors",
            joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "id")})
    private List<Author> authors;

    @ApiModelProperty(notes = "This book user")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

    @ApiModelProperty(notes = "This book status")
    @Enumerated(EnumType.STRING)
    private Status status;

    private Date givenDate;
    private Date dueDate;

    public Book(String title) {
        this.title = title;
    }

    public void notifyMe() {
        if (this.getUser() != null) {
            System.out.println("Book owned by " + this.getUser().getUsername());
            this.getUser().notify(this);
        } else {
            System.out.println("Book is free");
        }
    }
}

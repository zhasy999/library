package kz.iitu.library.models;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity

@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "book_genres",
            joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "genre_id", referencedColumnName = "id")})
    private List<Genre> genres;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "book_authors",
            joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "id")})
    private List<Author> authors;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Date givenDate;
    private Date dueDate;


    public User getUser() {
        return user;
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setTitle(String title) {
        this.title=title;
    }

    public void setAuthors(List<Author> authors) {
        this.authors=authors;
    }

    public void setGenres(List<Genre> genres) {
        this.genres=genres;
    }

    public void setStatus(Status status) {
        this.status=status;
    }

    public void setUser(User user) {
        this.user=user;
    }

    public void setId(long id) {
        this.id=id;
    }

    public void setGivenDate(Date date) {
        this.givenDate=date;
    }

    public void setDueDate(Date date) {
        this.dueDate=date;
    }

}

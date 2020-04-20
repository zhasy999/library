package kz.iitu.library.models;


import javax.persistence.*;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name = "users")
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Type type;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Book> books;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name +
                ", type='" + type +
                '}';
    }
    public void notify(Book book){
        System.out.println("Book " + book.getTitle() + " owned" );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public void setType(Type type) {
        this.type=type;
    }

    public Long getId() {
        return id;
    }

    public Type getType() {
        return type;
    }
}

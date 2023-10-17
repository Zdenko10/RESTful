package zdenko.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import zdenko.constant.RoleType;
import java.util.Date;
import java.util.List;

@Entity(name = "person")
@Getter
@Setter
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date birthDate;
    private String country;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String biography;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleType role;

    @OneToMany(mappedBy = "director")
    private List<MovieEntity> directedMovies;

    @ManyToMany(mappedBy = "actors")
    private List<MovieEntity> actedInMovies;

}

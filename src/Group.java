
@Entity
@Table(name="Groups")
public class Group {
    @Id
    private Integer id;
    private String name;
    @Column(name="ISBN_NUMBER")
    private String isbn;

}
package ImageHoster.model;

import javax.persistence.*;
import java.util.List;

//@Entity annotation specifies that the corresponding class is a JPA entity
@Entity
//@Table annotation provides more options to customize the mapping.
//Here the name of the table to be created in the database is explicitly mentioned as 'tags'. Hence the table named 'tags' will be created in the database with all the columns mapped to all the attributes in 'Tag' class
@Table(name = "Tags")
public class Tag {

    //@Id annotation specifies that the corresponding attribute is a primary key
    @Id
    //@Column annotation specifies that the attribute will be mapped to the column in the database.
    //Here the column name is explicitly mentioned as 'id'
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    //The annotation for many to many relationship between 'images' and 'tags' table where they are mapped by 'tags' field in the 'images' table
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tags")
    private List<Image> images;

    public Tag() {
    }

    public Tag(String tagName) {
        this.name = tagName;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}

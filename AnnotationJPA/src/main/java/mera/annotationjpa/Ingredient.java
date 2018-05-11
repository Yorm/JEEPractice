package mera.annotationjpa;


import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "ingredients")
public class Ingredient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_gen")
    @SequenceGenerator(name="seq_gen",sequenceName="seq_gen", allocationSize=1,initialValue = 1)
    @Column(name = "id")
    private long id;
    @Column(name = "ingredient")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   

}
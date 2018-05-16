
package mera.annotationjpa;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "telephones")
@SequenceGenerator(name="seq_tel",sequenceName="seq_tel", allocationSize=1,initialValue = 1)
public class Telephone implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_tel")
    private long id;
    
    @ManyToOne
    @JoinColumn(name = "id_user", nullable=false)
    private User user;
    
    private String number;
    private String model;

    public Telephone() {}

    public Telephone(String number, String model) {
        this.number = number;
        this.model = model;
        this.user = new User();
    }   

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

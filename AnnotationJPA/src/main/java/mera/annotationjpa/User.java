
package mera.annotationjpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "users")
@SequenceGenerator(name="seq_user",sequenceName="seq_user", allocationSize=1,initialValue = 1)
public class User implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_user")
    @Column(name = "userid")
    private long id;
    
    private String name;
    
    private Integer age;
    
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL /*, fetch = FetchType.LAZY*/, orphanRemoval = true)
    private List<Telephone> tel;

    @OneToOne
    private StatIP statIp;

    public User(){}

    public User(String name, Integer age) {
        this.tel = new ArrayList<>();
        this.name = name;
        this.age = age;
    }

    public List<Telephone> getTel() {
        return tel;
    }

    public void setTel(List<Telephone> tel) {    
        this.tel = tel;
    }

    public StatIP getStatIp() {
        return statIp;
    }

    public void setStatIp(StatIP statIp) {
        this.statIp = statIp;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
       
}

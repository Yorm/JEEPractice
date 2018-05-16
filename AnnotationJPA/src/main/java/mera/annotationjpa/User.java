
package mera.annotationjpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
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
    
    @OneToOne
    private StatIP statIp;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL /*, fetch = FetchType.LAZY*/, orphanRemoval = true)
    private List<Telephone> tel;
    
    @ManyToMany
    private Set<Pictures> pics;

    public User(){}

    public User(String name, Integer age) {
        this.pics = new HashSet<>();
        this.tel = new ArrayList<>();
        this.name = name;
        this.age = age;
    }
    
    public void addPic(Pictures p){
        pics.add(p);
    }
    public void addTel(Telephone t){
        tel.add(t);
    }

    public Set<Pictures> getPics() {
        return pics;
    }

    public void setPics(Set<Pictures> pics) {
        this.pics = pics;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.name);
        hash = 43 * hash + Objects.hashCode(this.age);
        hash = 43 * hash + Objects.hashCode(this.statIp);
        hash = 43 * hash + Objects.hashCode(this.tel);
        hash = 43 * hash + Objects.hashCode(this.pics);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.age, other.age)) {
            return false;
        }
        if (!Objects.equals(this.statIp, other.statIp)) {
            return false;
        }
        if (!Objects.equals(this.tel, other.tel)) {
            return false;
        }
        if (!Objects.equals(this.pics, other.pics)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", age=" + age + ", statIp=" + statIp + ", tel=" + tel + ", pics=" + pics + '}';
    }
       
}

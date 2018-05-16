package mera.annotationjpa;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.*;

@Entity
@Table(name = "pic")
public class Pictures implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "picId")
    private long id;
    
    @ManyToMany(mappedBy="pics")
    private Set<User> users;
    
    private Integer x;
    private Integer y;

    public Pictures(){}

    public Pictures(int x,int y) {
        this.users = new HashSet<>();
        this.x=x;
        this.y=y;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
    
    public void addUser(User u){
        users.add(u);
    }
    
    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }  

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.users);
        hash = 79 * hash + Objects.hashCode(this.x);
        hash = 79 * hash + Objects.hashCode(this.y);
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
        final Pictures other = (Pictures) obj;
        if (!Objects.equals(this.users, other.users)) {
            return false;
        }
        if (!Objects.equals(this.x, other.x)) {
            return false;
        }
        if (!Objects.equals(this.y, other.y)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pictures{" + "id=" + id + ", users=" + users + ", x=" + x + ", y=" + y + '}';
    }
    
    
}
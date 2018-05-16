
package mera.annotationjpa;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "statIp")
public class StatIP implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid")
    private long id;
    
    private String ip;
    
    @OneToOne(mappedBy="statIp", optional=false)
    private User user;

    public StatIP(){}

    public StatIP(String ip) {
        this.ip = ip;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    
}

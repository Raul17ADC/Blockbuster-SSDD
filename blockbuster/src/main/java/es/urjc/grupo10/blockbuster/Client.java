package es.urjc.grupo10.blockbuster;

import java.util.Objects;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.*;


@Data
@Entity

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  
    private Long usercode;

    private String email;
    private String userName;
    private String password;
    
    public Client() {
    }
    
    public Client(String email, String UserName, String password) {
        
        this.email = email;
        this.userName = UserName;
        this.password = password;
        
    }

   

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String UserName) {
        this.userName = UserName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

   

    @Override
    public String toString() {
        return "Client{" +
                "email='" + email + '\'' +
                ", username='" + userName + '\'' +
                ", password='" + password + '\'' +
                
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(userName, client.userName) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, userName, password);
    }
}

   

    


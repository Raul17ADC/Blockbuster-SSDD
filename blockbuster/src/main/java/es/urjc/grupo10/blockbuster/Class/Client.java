package es.urjc.grupo10.blockbuster.Class;

import java.util.ArrayList;
import java.util.List;
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
    private String logo;

    private List<String> cart = new ArrayList<>();
    
    public Client() {
    }
    
    public Client(String email, String UserName, String password) {
        
        this.email = email;
        this.userName = UserName;
        this.password = password;
        this.logo = "https://img1.freepng.es/20180319/row/kisspng-computer-icons-google-account-user-profile-iconfin-png-icons-download-profile-5ab0301d8907a6.3404305715214960935613.jpg";
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

    public List<String> getCart() {
        return this.cart;
    }
    public String getLogo() {
        return logo;
    }
    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "Client{" +
                "email='" + email + '\'' +
                ", username='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", cart='" + cart + '\'' +
                ", logo='" + logo + '\'' +
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

   

    


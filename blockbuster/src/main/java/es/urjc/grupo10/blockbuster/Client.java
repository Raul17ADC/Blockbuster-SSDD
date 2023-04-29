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
    private String name;
    private String password;
    
    
    
    public Client(String email, String name, String password) {
        
        this.email = email;
        this.name = name;
        this.password = password;
        
    }

    

    

   

    
}

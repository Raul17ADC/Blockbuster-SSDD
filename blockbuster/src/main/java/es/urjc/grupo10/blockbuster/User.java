package es.urjc.grupo10.blockbuster;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

public class User {
    private Long usercode;
    private String email;
    private String name;
    private String password;
    

    public User(){

    }

    public User(Long usercode ,String email, String name, String password) {
        this.usercode = usercode;
        this.email = email;
        this.name = name;
        this.password = password;
        
    }

    public Long getId() {
        return usercode;
    }

    public void setId(Long id) {
        this.usercode = id;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

   

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, password);
    }
}

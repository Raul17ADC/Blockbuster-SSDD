package es.urjc.grupo10.blockbuster.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.urjc.grupo10.blockbuster.Class.Client;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long>{
    List<Client> findByUserName(String userName);
    List<Client> findByUserNameAndPassword(String userName,String password);
}

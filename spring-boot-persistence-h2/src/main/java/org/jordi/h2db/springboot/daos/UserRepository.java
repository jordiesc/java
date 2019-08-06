package org.jordi.h2db.springboot.daos;




import java.util.List;
import org.jordi.h2db.springboot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    List<User> findByAgeGreaterThan(int i);
}

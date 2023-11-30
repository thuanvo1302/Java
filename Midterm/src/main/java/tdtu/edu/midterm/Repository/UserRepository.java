package tdtu.edu.midterm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tdtu.edu.midterm.Models.User;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserByEmail(String email);
//    boolean checkEmail(String email);

}

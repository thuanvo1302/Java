package tdtu.edu.midterm.Service;

import tdtu.edu.midterm.Models.User;

import java.util.List;

public interface UserService {

    List<User> getAll();


    User get(String email);

    User add(User u);

    void delete(int id);

//    boolean checkEmail(String email);
}
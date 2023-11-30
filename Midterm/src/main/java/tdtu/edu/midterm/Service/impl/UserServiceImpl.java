package tdtu.edu.midterm.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tdtu.edu.midterm.Models.User;
import tdtu.edu.midterm.Repository.UserRepository;
import tdtu.edu.midterm.Service.UserService;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncode;
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
    @Override


    public User get(String email) {
        return userRepository.getUserByEmail(email);
    }
    @Override

    public User add(User u) {
        return userRepository.save(u);
    }
    @Override


    public void delete(int id) {
        userRepository.deleteById(id);
    }



//    public boolean checkEmail(String email){return userRepository.checkEmail(email);}
}

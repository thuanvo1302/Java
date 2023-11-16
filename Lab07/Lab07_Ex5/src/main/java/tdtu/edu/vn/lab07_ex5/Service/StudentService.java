package tdtu.edu.vn.lab07_ex5.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.vn.lab07_ex5.Model.Student;
import tdtu.edu.vn.lab07_ex5.Repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepo;




    public List<Student> greaterOrEqual(int age) {
        return studentRepo.findStudentsByAge(age);
    }
    public Student findEmail(String email) {
        return studentRepo.findEmail(email);
    }


    public List<Student> findByName(String name) {
        return studentRepo.findByName(name);
    }
}

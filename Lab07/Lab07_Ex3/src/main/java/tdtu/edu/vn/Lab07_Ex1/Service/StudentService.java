package tdtu.edu.vn.Lab07_Ex1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.vn.Lab07_Ex1.Model.Student;
import tdtu.edu.vn.Lab07_Ex1.Repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepo;
    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepo.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepo.findById(id);
    }

    public Student updateStudent(Student updatedStudent) {
        return studentRepo.save(updatedStudent);
    }

    public void deleteStudentById(Long id) {
        studentRepo.deleteById(id);
    }

}

package tdtu.edu.vn.Lab07_Ex1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tdtu.edu.vn.Lab07_Ex1.Model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}

package tdtu.edu.vn.Lab07_Ex4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tdtu.edu.vn.Lab07_Ex4.Model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByAgeGreaterThanEqual(int age);

    public long countByIelts(double ieltsScore);

    public List<Student> findByNameContainingIgnoreCase(String name);
}

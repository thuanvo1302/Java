package tdtu.edu.vn.lab07_ex5.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tdtu.edu.vn.lab07_ex5.Model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE s.age >= :age")
    public List<Student> findStudentsByAge(@Param("age") int age);

    @Query("SELECT s FROM Student s WHERE s.email = :email")
    public Student findEmail(@Param("email") String email);

    @Query("SELECT s FROM Student s WHERE lower(s.name) LIKE %:name%")
    public List<Student> findByName(@Param("name") String name);
}
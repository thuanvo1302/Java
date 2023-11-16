package tdtu.edu.vn.lab07_ex6.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import tdtu.edu.vn.lab07_ex6.Model.Student;

public interface CloneStudentRepository extends PagingAndSortingRepository<Student, Integer> {
    public Page<Student> findAllByOrderByAgeDescIeltsAsc(Pageable pageable);

}
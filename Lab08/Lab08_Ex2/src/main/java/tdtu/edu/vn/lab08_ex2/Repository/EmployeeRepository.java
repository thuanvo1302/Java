package tdtu.edu.vn.lab08_ex2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tdtu.edu.vn.lab08_ex2.Models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

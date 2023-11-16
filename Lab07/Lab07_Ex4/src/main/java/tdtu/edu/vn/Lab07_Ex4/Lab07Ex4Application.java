package tdtu.edu.vn.Lab07_Ex4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import tdtu.edu.vn.Lab07_Ex4.Model.Student;
import tdtu.edu.vn.Lab07_Ex4.Service.StudentServices;

import java.util.List;

@SpringBootApplication
public class Lab07Ex4Application extends SpringBootServletInitializer implements CommandLineRunner{

	@Autowired
	private StudentServices studentServices;
	public static void main(String[] args) {
		SpringApplication.run(Lab07Ex4Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception{
		List<Student> students = studentServices.findStudentsByAgeGreaterThanEqual(20);
		for(Student s : students){
			System.out.println(s);
		}

		System.out.println(studentServices.countStudentsByIeltsScore(7));

		System.out.println(studentServices.findStudentsByNameContainingIgnoreCase("phu"));
	}
}

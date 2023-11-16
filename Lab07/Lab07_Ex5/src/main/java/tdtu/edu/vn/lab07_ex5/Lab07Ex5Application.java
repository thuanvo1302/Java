package tdtu.edu.vn.lab07_ex5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import tdtu.edu.vn.lab07_ex5.Model.Student;
import tdtu.edu.vn.lab07_ex5.Service.StudentService;

import java.util.List;

@SpringBootApplication
public class Lab07Ex5Application extends SpringBootServletInitializer implements CommandLineRunner {
	@Autowired
	private StudentService studentServices;

	public static void main(String[] args) {
		SpringApplication.run(Lab07Ex5Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception{
		List<Student> students1 = studentServices.greaterOrEqual(20);
		for(Student s : students1){
			System.out.println(s);
		}

		List<Student> students2 = studentServices.findByName("Student2");
		for(Student s : students2){
			System.out.println(s);
		}

		Student student3 = studentServices.findEmail("Student2@gmail");

		System.out.println(student3.getName());


	}
}

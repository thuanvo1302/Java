package tdtu.edu.vn.Lab07_Ex1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import tdtu.edu.vn.Lab07_Ex1.Model.Student;
import tdtu.edu.vn.Lab07_Ex1.Service.StudentService;

import java.util.Optional;

@SpringBootApplication
public class Lab07Ex1Application extends SpringBootServletInitializer implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Lab07Ex1Application.class, args);
	}
	@Bean
	public CommandLineRunner demo(){
		return (args) -> {
			System.out.println("Vo Minh Thuan - 52100588");
		};
	}
	@Autowired
	private StudentService studentServices;

	@Override
	public void run(String...args) throws Exception {
		Student student1 = new Student(1L, "Student1", 20, "Student1@gmail");
		studentServices.createStudent(student1);
		Student student2 = new Student(2L, "Student2", 20, "Student2@gmail");
		studentServices.createStudent(student2);

		Student student3 = new Student(3L, "Student3", 20, "Student3@gmail");
		studentServices.createStudent(student3);
		System.out.println("Add 3 Students");
		studentServices.getAllStudents().forEach(System.out::println);


		Optional<Student> updateStudent = studentServices.getStudentById(1L);
		if(updateStudent.isPresent()){
			Student student = updateStudent.get();
			student.setName("New Student name");
			studentServices.createStudent(student);
		}
		System.out.println("Update");
		studentServices.getAllStudents().forEach(System.out::println);

		System.out.println("Delete");
		studentServices.deleteStudentById(3L);
		studentServices.getAllStudents().forEach(System.out::println);




	}
}

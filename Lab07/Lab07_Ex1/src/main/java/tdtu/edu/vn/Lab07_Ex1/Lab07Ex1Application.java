package tdtu.edu.vn.Lab07_Ex1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;


import java.util.Optional;

@SpringBootApplication
public class Lab07Ex1Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab07Ex1Application.class, args);
	}
	@Bean
	public CommandLineRunner demo(){
		return (args) -> {
			System.out.println("Vo Minh Thuan - 52100588");
		};
	}



}

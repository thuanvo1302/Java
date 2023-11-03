package tdtu.edu.lab06_ex5;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.AbstractApplicationContext;

@PropertySource("classpath:application.properties")
public class Lab06Ex5Application
{
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(Demo.class);
		Demo name = context.getBean(Demo.class);

		System.out.println(name.getMyProp());

		context.close();
	}
}

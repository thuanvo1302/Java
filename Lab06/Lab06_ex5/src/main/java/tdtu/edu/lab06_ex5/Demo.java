package tdtu.edu.lab06_ex5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class Demo {
    @Value("${my.property}")
    private String myProp;

    public String getMyProp() {
        return myProp;
    }
}
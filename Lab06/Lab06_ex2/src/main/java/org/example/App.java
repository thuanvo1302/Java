package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(appConfig.class);

        Product bean1 = context.getBean("product1", Product.class);
        Product bean2 = context.getBean("product2", Product.class);
        Product bean3 = context.getBean("product3", Product.class);

        System.out.println("Bean 1: " + bean1);
        System.out.println("Bean 2: " + bean2);
        System.out.println("Bean 3: " + bean3);

        // Confirm bean scopes
        System.out.println("Bean 1 is a prototype: " + (bean1 != context.getBean("product1", Product.class)));
        System.out.println("Bean 2 is a prototype: " + (bean2 != context.getBean("product2", Product.class)));
        System.out.println("Bean 3 is a singleton: " + (bean3 == context.getBean("product3", Product.class)));
    }
}

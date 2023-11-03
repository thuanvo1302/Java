package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("appConfig.xml");

        Product bean1 = context.getBean("bean1", Product.class);
        Product bean2 = context.getBean("bean2", Product.class);
        Product bean3 = context.getBean("bean3", Product.class);

        System.out.println("Bean 1: " + bean1.getName());
        System.out.println("Bean 2: " + bean2.getName());
        System.out.println("Bean 3: " + bean3.getName());


        System.out.println("Bean 1 is a prototype: " + (bean1 != context.getBean("bean1", Product.class)));
        System.out.println("Bean 2 is a prototype: " + (bean2 != context.getBean("bean2", Product.class)));
        System.out.println("Bean 3 is a singleton: " + (bean3 == context.getBean("bean3", Product.class)));
    }
}

package ru.javawebinar.topjava;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.repository.UserRepository;

import java.util.Arrays;

public class SpringMain {
//    public static void main(String[] args) {
//        ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml"); //creates application context spring, which is described in xml, which is located in the classpath
//        System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
//
////        UserRepository userRepository = (UserRepository) appCtx.getBean("inmemoryUserRepository"); //can take any bins from context
//        UserRepository userRepository = appCtx.getBean(UserRepository.class); //can take any bins from context(take access from java EE toward spring)
//        userRepository.getAll();
//        appCtx.close(); //close all resources which been used during the work + all maps in the context spring will be deleted
//    }



public static void main(String[] args) {
    ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml"); //creates application context spring, which is described in xml, which is located in the classpath
    System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));

//        UserRepository userRepository = (UserRepository) appCtx.getBean("inmemoryUserRepository"); //can take any bins from context
    MealRepository mealRepository = appCtx.getBean(MealRepository.class); //can take any bins from context(take access from java EE toward spring)
    mealRepository.getAll();
    appCtx.close(); //close all resources which been used during the work + all maps in the context spring will be deleted
}
}

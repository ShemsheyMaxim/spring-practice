package spring.intro;

import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.intro.config.AppConfig;
import spring.intro.model.User;
import spring.intro.service.UserService;

public class Main {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setFirstName("Max");
        user1.setLastName("Shemshey");
        user1.setEmail("shanhaymax@gmail.com");
        User user2 = new User();
        user2.setFirstName("Olenka");
        user2.setLastName("Bezuhla");
        user2.setEmail("jewelsalenka@gmail.com");
        User user3 = new User();
        user3.setFirstName("Kristina");
        user3.setLastName("Mileykina");
        user3.setEmail("kristina.mileykina@gmail.com");

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        List<User> users = userService.listUsers();
        System.out.println(users);
    }
}

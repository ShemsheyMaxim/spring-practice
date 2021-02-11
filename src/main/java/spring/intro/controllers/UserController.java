package spring.intro.controllers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.intro.dto.UserResponseDto;
import spring.intro.model.User;
import spring.intro.service.UserMapper;
import spring.intro.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserMapper userMapper;
    private final UserService userService;

    @Autowired
    public UserController(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @GetMapping("/inject")
    public String inject() {
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
        User user4 = new User();
        user4.setFirstName("Ella");
        user4.setLastName("Belozor");
        user4.setEmail("karamelka.ya@gmail.com");
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);
        return "Users were add";
    }

    @GetMapping("/{id}")
    public UserResponseDto get(@PathVariable(name = "id") Long userId) {
        User user = userService.get(userId);
        return userMapper.mapUserToUserResponseDto(user);
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.listUsers()
                .stream()
                .map(userMapper::mapUserToUserResponseDto)
                .collect(Collectors.toList());
    }
}

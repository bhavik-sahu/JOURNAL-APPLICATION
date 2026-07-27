package finalchance.demo.controller;

import finalchance.demo.entity.User;
import finalchance.demo.repository.UserEntryRepository;
import finalchance.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserEntryRepository userRepository;

    @PutMapping
    public ResponseEntity<?> updateuser(@RequestBody User user){
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String userName = authentication.getName();

    User userInDb=userService.findByusername(userName);
    if(userInDb!=null){
        userInDb.setUserName(user.getUserName());
        userInDb.setPassword(user.getPassword());
        userService.savenewEntry(userInDb);
    }
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteuserbyid(){
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    userRepository.deleteUserByUserName(authentication.getName());
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<?> greeting(){
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String userName = authentication.getName();
    User user = userService.findByusername(userName);
    return new ResponseEntity<>(Map.of(
        "username", user.getUserName(),
        "roles", user.getRoles()
    ), HttpStatus.OK);
    }
}

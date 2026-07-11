package finalchance.demo.controller;

import finalchance.demo.apiresponse.api_response;
import finalchance.demo.entity.User;
import finalchance.demo.repository.UserEntryRepository;
import finalchance.demo.service.UserService;
import finalchance.demo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserEntryRepository userRepository;
    @Autowired
    private WeatherService weatherService;


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
        api_response response = weatherService.getdata("udaipur");

String greeting="";
        if(response!=null){
            greeting =", Weather feels like "+response.getCurrent().getFeelslike();
        }


    return new ResponseEntity<>("hi "+authentication.getName() + greeting,HttpStatus.OK);
    }
}

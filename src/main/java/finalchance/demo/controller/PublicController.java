package finalchance.demo.controller;

import finalchance.demo.entity.User;
import finalchance.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
    @RequestMapping("/public")
public class PublicController {

@Autowired
private UserService userService;

@GetMapping("/healthcheck")
public String healthcheck(){
        return "OK";
    }
@PostMapping("/createuser")
public ResponseEntity<?> createuser(@RequestBody User user){

    boolean created = userService.savenewEntry(user);

    if(created){

        return new ResponseEntity<>(
                "User created successfully",
                HttpStatus.CREATED
        );
    }

    return new ResponseEntity<>(
            "Username already exists",
            HttpStatus.BAD_REQUEST
    );
}

@PostMapping("/createadmin")
public ResponseEntity<?> createadmin(@RequestBody User user){
    userService.saveAdmin(user);
    return new ResponseEntity<>("Admin user created successfully", HttpStatus.CREATED);
}
}

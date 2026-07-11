package finalchance.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class userrepositoryiimpltests {

    @Autowired
    private userrepositoryimpl userrepositoryImpl;

    @Test
    public void testSaveNewUser(){
        userrepositoryimpl.getUserforSA();
    }
}

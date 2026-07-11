//package finalchance.demo.service;
//
//import finalchance.demo.entity.User;
//import finalchance.demo.repository.UserEntryRepository;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//public class UserServiceTests {
//    @Autowired
//    private UserEntryRepository userEntryRepository;
//
//    @Disabled
//    @Test
//    public void testbyusername(){
//        User user =userEntryRepository.findByUserName("bhavik");
//
//        assertTrue(!user.getJournalEntryList().isEmpty());
//
//    }
//    @Disabled
//    @ParameterizedTest
//    @CsvSource({
//            "1,1,2"
//    })
//    public void test(int a,int b,int expected){
//        assertEquals(expected,a+b);
//    }
//
//}

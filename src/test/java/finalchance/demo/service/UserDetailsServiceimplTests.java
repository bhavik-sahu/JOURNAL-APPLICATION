//package finalchance.demo.service;
//
//import finalchance.demo.repository.UserEntryRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//
//import static org.mockito.Mockito.*;
//
//public class UserDetailsServiceimplTests {
//    @InjectMocks
//     private  userDetailsServiceImpl userDetailsService;
//
//    @Mock
//    private UserEntryRepository userEntryRepository;
//
//    @BeforeEach
//    void setup(){
//        MockitoAnnotations.initMocks(this);
//    }
//    @Disabled
//    @Test
//     void loadbyusernametest(){
//         when(userEntryRepository.findByUserName("bhavik")).thenReturn((finalchance.demo.entity.User) User.builder().username("bhavik").password("sahu").build());
//         UserDetails user = userDetailsService.loadUserByUsername("bhavik");
//        Assertions.assertNotNull(user);
//     }
//}

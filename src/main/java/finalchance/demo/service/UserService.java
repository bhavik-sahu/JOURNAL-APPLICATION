package finalchance.demo.service;

import finalchance.demo.entity.User;
import finalchance.demo.repository.UserEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

    @Component
    @Slf4j
public class UserService {
        @Autowired
        private UserEntryRepository userEntryRepository;

        public static final PasswordEncoder passwordencoder= new BCryptPasswordEncoder();
        public boolean savenewEntry(User userEntry){
            try{

            userEntry.setPassword(passwordencoder.encode(userEntry.getPassword()));
            userEntry.setRoles(Arrays.asList("USER"));
            userEntryRepository.save(userEntry);
            return true;
            }
            catch(Exception e){
                log.error("error occured while making the user{}",userEntry.getUserName(),e);
                return false;
            }
        }
        public void saveAdmin(User userEntry){
            userEntry.setPassword(passwordencoder.encode(userEntry.getPassword()));
            userEntry.setRoles(Arrays.asList("USER","ADMIN"));
            userEntryRepository.save(userEntry);
        }

        public void saveentry(User user){
            userEntryRepository.save(user);
        }

        public List<User> getAll(){
            return userEntryRepository.findAll();
        }
        public Optional<User> findById(ObjectId id){
            return userEntryRepository.findById(id);
        }
        public boolean deleteById(ObjectId id){
            userEntryRepository.deleteById(id);
            return true;
        }
        public User findByusername(String userName){
            return userEntryRepository.findByUserName(userName);
        }
    }



package finalchance.demo.repository;

import finalchance.demo.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

    public interface UserEntryRepository extends MongoRepository<User,ObjectId> {
User findByUserName(String userName);

void deleteUserByUserName(String username);


    }

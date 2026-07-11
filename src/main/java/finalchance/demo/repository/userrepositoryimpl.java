package finalchance.demo.repository;

import finalchance.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class userrepositoryimpl {

@Autowired
private static MongoTemplate mongoTemplate;

    public static List<User> getUserforSA(){
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is("vipul"));
        List<User> users = mongoTemplate.find(query, User.class);
        return users;
    }
}

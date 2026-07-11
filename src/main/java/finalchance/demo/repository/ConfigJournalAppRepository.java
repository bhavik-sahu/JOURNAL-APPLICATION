package finalchance.demo.repository;

import finalchance.demo.entity.ConfigJournalAppEntity;
import finalchance.demo.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalAppRepository extends MongoRepository<ConfigJournalAppEntity,ObjectId> {

}

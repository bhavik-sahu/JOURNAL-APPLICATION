package finalchance.demo.Cache;

import finalchance.demo.entity.ConfigJournalAppEntity;
import finalchance.demo.repository.ConfigJournalAppRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {
    public Map<String,String> appCache = new HashMap<>();

    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;

@PostConstruct
    public void init(){
    List<ConfigJournalAppEntity> all = configJournalAppRepository.findAll();
    for (ConfigJournalAppEntity configJournalAppentity : all) {
        appCache.put(configJournalAppentity.getKey(),configJournalAppentity.getValue());
    }
    }
}

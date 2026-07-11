package finalchance.demo.service;

import finalchance.demo.entity.JournalEntry;
import finalchance.demo.entity.User;
import finalchance.demo.repository.JournalEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private AIService aiService;

    private static final Logger logger = LoggerFactory.getLogger(JournalEntryService.class);

    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName) {
        try {
            User user = userService.findByusername(userName);

            journalEntry.setDate(LocalDateTime.now());

            // Generate AI insight
            String text = journalEntry.getTitle() + "\n\n" + journalEntry.getContent();
            System.out.println("Calling Gemini...");

            var insight = aiService.generateInsight(text);

            System.out.println("Sentiment: " + insight.getSentiment());
            System.out.println("Tags: " + insight.getTags());
            System.out.println("Reflection: " + insight.getReflection());

            journalEntry.setInsight(insight);

            System.out.println("Insight set: " + journalEntry.getInsight());

            JournalEntry saved = journalEntryRepository.save(journalEntry);

            user.getJournalEntryList().add(saved);
            userService.saveentry(user);

        } catch (Exception e) {
            log.error("Error occurred while saving journal entry for user: {}", userName, e);
            throw new RuntimeException("An error occurred while saving the entry", e);
        }
    }
    public void saveEntry (JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }
    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }
    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    @Transactional
    public boolean deleteById(ObjectId id, String username){
        if(journalEntryRepository.existsById(id)){
        User user = userService.findByusername(username);
            boolean remove = user.getJournalEntryList().removeIf(x -> x.getId().equals(id));
            if(remove){
            userService.saveentry(user);
        journalEntryRepository.deleteById(id);
        return true;

            }
return false;
        }
        return false;
    }


}

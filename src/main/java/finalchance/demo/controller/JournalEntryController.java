//package finalchance.demo.controller;
//import finalchance.demo.entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/journal")
//public class JournalEntryController {
//
//    private Map<Long,JournalEntry> journalEntries = new HashMap<>();
//
//    @GetMapping
//    public List<JournalEntry> getallJournalEntriesofUser(){
//        return new ArrayList<>(journalEntries.values());
//    }
//    @PostMapping
//    public boolean createEntry(@RequestBody JournalEntry myEntry){
//journalEntries.put(myEntry.getId(),myEntry);
//return true;
//    }
//    @GetMapping("/id")
//    public JournalEntry getJournalEntryById(@RequestParam long id){
//return journalEntries.get(id);
//    }
//    @DeleteMapping("/id")
//    public JournalEntry deleteJournalEntryById(@RequestParam long id){
//return journalEntries.remove(id);
//    }
//@PutMapping("/id")
//    public JournalEntry updatejournlabyid(@RequestParam long id,@RequestBody JournalEntry myEntry){
//        return journalEntries.put(id,myEntry);
//    }
//}

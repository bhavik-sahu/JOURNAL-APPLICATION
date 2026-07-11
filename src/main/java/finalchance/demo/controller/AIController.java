package finalchance.demo.controller;

import finalchance.demo.entity.Insight;
import finalchance.demo.service.AIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ai")
public class AIController {

    @Autowired
    private AIService aiService;

    @GetMapping
    public Insight test() {

        return aiService.generateInsight(
                "Today I studied Spring Boot for 3 hours and felt productive."
        );
    }
}
package finalchance.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import finalchance.demo.apiresponse.GeminiRequest;
import finalchance.demo.apiresponse.GeminiResponse;
import finalchance.demo.entity.Insight;
import org.springframework.http.*;
import java.util.List;


    @Component
    public class AIService {

        @Value("${gemini.api.key}")
        private String apiKey;

        @Value("${gemini.api.url}")
        private String apiUrl;

        @Autowired
        private RestTemplate restTemplate;

        private final ObjectMapper objectMapper = new ObjectMapper();

        public Insight generateInsight(String journalText) {

            try {

                String prompt = """
                Analyze the following journal entry.

                Return ONLY valid JSON.

                {
                  "sentiment":"",
                  "tags":[],
                  "reflection":""
                }

                Journal:
                """ + journalText;

                GeminiRequest request = new GeminiRequest(
                        List.of(
                                new GeminiRequest.Content(
                                        List.of(
                                                new GeminiRequest.Part(prompt)
                                        )
                                )
                        )
                );

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);

                HttpEntity<GeminiRequest> entity =
                        new HttpEntity<>(request, headers);
                System.out.println("URL = " + apiUrl + "?key=" + apiKey);
                System.out.println(objectMapper.writeValueAsString(request));
                ResponseEntity<GeminiResponse> response =
                        restTemplate.postForEntity(
                                apiUrl + "?key=" + apiKey,
                                entity,
                                GeminiResponse.class
                        );

                String json = response.getBody()
                        .getCandidates()
                        .get(0)
                        .getContent()
                        .getParts()
                        .get(0)
                        .getText();

                System.out.println("Gemini Response:");
                System.out.println(json);

                return objectMapper.readValue(json, Insight.class);

            } catch (Exception e) {
                throw new RuntimeException("Failed to generate AI insight", e);
            }
        }

    }

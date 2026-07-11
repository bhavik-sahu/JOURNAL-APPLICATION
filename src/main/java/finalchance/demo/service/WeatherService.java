package finalchance.demo.service;

import finalchance.demo.Cache.AppCache;
import finalchance.demo.apiresponse.api_response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {
    @Value("${weather.api.key}")
    private String apikey;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    AppCache api;

    public api_response getdata(String city){
        String replace = api.appCache.get("weather_api").replace("<apikey>",apikey).replace("<city>",city);
        ResponseEntity<api_response> exchange = restTemplate.exchange(replace, HttpMethod.GET, null, api_response.class);
        api_response body = exchange.getBody();
        return body;
    }
}

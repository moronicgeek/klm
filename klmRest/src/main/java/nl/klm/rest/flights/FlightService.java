package nl.klm.rest.flights;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    @Value("${flight.baseUrl}")
    private String baseURL;

    @Autowired
    private OAuth2RestOperations restTemplate;


    public ResponseEntity<Fare> getFlight(String departure, String destination){
        String test = baseURL+String.format("/%s/%s",departure,destination);
        System.out.println(test);
        return restTemplate.getForEntity(test,Fare.class);
    }


}

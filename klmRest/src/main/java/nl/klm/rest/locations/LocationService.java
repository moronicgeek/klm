package nl.klm.rest.locations;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class LocationService {

    @Value("${location.baseUrl}")
    private String baseURL;

    @Autowired
    private OAuth2RestOperations restTemplate;


    @Cacheable("locations")
    public List<Location> getFlight(String size,
                                    String page,
                                    String lang,
                                    String term){

//        Map<String, String> params = new HashMap<>();
//        params.put("size", size);
//        params.put("page", page);
//        params.put("lang", lang);
//        params.put("term", term);

        UriComponentsBuilder url = UriComponentsBuilder
                .fromUriString(baseURL)
                .queryParam("term", term);

        ObjectMapper mapper = new ObjectMapper();
        try {
          JsonNode node = mapper.readTree( restTemplate.getForEntity(url.toUriString(),String.class).getBody());

            Location[] locations = mapper.convertValue(node.path("_embedded").path("locations"),Location[].class);

            return Arrays.asList(locations);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

}

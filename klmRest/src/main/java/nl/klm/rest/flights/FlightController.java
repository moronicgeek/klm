package nl.klm.rest.flights;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FlightController {

    @Autowired
    private FlightService service;


    @RequestMapping(method = RequestMethod.GET , path = "/flight/{departure}/{destination}")
    public Fare getFlight(@PathVariable("departure") final String departure,
                            @PathVariable("destination") final String destination){
        return service.getFlight(departure,destination).getBody();
    }

}

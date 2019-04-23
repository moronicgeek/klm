package nl.klm.rest.locations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "location")

public class LocationController {

    @Autowired
    private LocationService locationService;



    @RequestMapping(method = RequestMethod.GET , path = "/locations")
    public List<Location> getLocations(@RequestParam(required = false) String size,
                                       @RequestParam(required = false) String page,
                                       @RequestParam(required = false) String lang,
                                       @RequestParam(required = false) String term){
        return locationService.getFlight(size,page,lang,term);
    }
}

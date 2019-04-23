package nl.klm.rest.locations;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
@Data
@AllArgsConstructor
public class Location {

    private String code;
    private String name;
    private String description;
    private Coordinates coordinates;
    private Location parent;
    private Set<Location> children;

    public Location() {

    }
}

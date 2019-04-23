package nl.klm.rest.flights;

import lombok.Data;

@Data
public class Fare {

    private double amount;
    private Currency currency;
    private String origin, destination;

    public Fare(){

    }

}

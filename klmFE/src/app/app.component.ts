import {Component, Input} from '@angular/core';
import {Location} from './location';
import {FlightService} from './flight.service';
import {Fare} from './fare';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [FlightService]
})
export class AppComponent {
  title = 'KLM Flights';
  departure: Location;
  destination: Location;
  fare = new Fare();

  constructor(private flightService: FlightService) {
  }

  search() {
    console.log(this.departure);
    console.log(this.destination);
    this.flightService.getFlights(this.departure.code, this.destination.code).then(
      value => {
        this.fare = value;
      }
    );
  }

  departureChange(message: Location): void {
    console.log(message);

    this.departure = message;
  }


  destinationChange(message: Location): void {
    console.log(message);
    this.destination = message;
  }



}

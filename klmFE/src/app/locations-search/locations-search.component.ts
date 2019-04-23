import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {LocationService} from '../location.service';
import {Location} from '../location';

@Component({
  selector: 'app-locations-search',
  templateUrl: './locations-search.component.html',
  styleUrls: ['./locations-search.component.css'],

  providers: [LocationService]
})
export class LocationsSearchComponent implements OnInit {

  term = '';
  locations: Location[];
  @Output()selectedLocation = new EventEmitter<Location>();

  constructor(private locationService: LocationService) {}


  ngOnInit() {

  }

  selectedItem(location: Location) {
    // this.selectedLocation = location;
    this.selectedLocation.emit(location);
    this.term = location.description;
    this.locations = [];
  }
  getLocations(term) {
    return this.locationService.getDetails(term);
  }

  search() {
   this.getLocations(this.term).then(value => {
     console.log(value)
     this.locations = value;
   } );


  }

}

import {Coordinates} from './coordinates';

export class Location {
  code: string;
  name: string;
  description: string
  coordinates: Coordinates ;
  parent: Location ;
  children: Set<Location> ;

}

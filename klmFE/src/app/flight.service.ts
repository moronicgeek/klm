import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../environments/environment';
import {Fare} from './fare';

@Injectable({providedIn: 'root'})
export class FlightService {

  constructor(private http: HttpClient) { }

  getFlights(departure, destination) {


    return this.http
      .get<Fare>(environment.API_URL + '/flight/' + departure + '/' + destination)
      .toPromise();
  }
}

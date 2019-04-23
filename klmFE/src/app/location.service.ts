import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {environment} from '../environments/environment';
import {Location} from './location';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LocationService {

  constructor(private http: HttpClient ) { }

  // getLocations(term: string): Observable<Location[]> {
  //   return this.http.get(environment.API_URL + '/airports?term=' + term);
  // }

  public getDetails(term: string): Promise<Location[]> {

    console.log(term);
    return this.http
      .get<Location[]>(environment.API_URL + '/location/locations?term=' + term)
      .toPromise();
  }
}

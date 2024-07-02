import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { EventModel } from '../model/eventModel';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class EventService {
  URL_API: string = 'http://localhost:9000/event';
  constructor(private httpClient: HttpClient) {

  }

  getEvents(): Observable<EventModel[]> {
    return this.httpClient.get<EventModel[]>(this.URL_API + '/list').pipe(map(res => res));
  }

  saveEvent(request: any): Observable<any> {
    return this.httpClient.post<any>(this.URL_API + '/save', request).pipe(map(resp => resp));
  }

  updateEvent(request: any): Observable<any> {
    return this.httpClient.post<any>(this.URL_API + '/update', request).pipe(map(resp => resp));
  }

  deleteEvent(id: number): Observable<any> {
    return this.httpClient.get<any>(this.URL_API + '/delete/' + id).pipe(map(resp => resp));
  }
}

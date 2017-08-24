import { Component, OnInit } from '@angular/core';

import { Event } from './domain/event';
import { EventPlace } from './domain/event-place';

const EVENTS: Event[] = [
  { id: 1, name: '6 Ola\'s birthday', place: { id: 1, name: 'Monkey Town'}},
  { id: 2, name: '4 Wojtek\'s birthday', place: { id: 1, name: 'Monkey Town'}}
];

@Component({
    selector: 'my-events',
    templateUrl: './events.component.html',
    styleUrls: [ './events.component.css' ]
})
export class EventsComponent implements OnInit {
    events: Event[];
    selectedEvent: Event;
    
    ngOnInit(): void {
        this.events = EVENTS;
    }

    onSelect(event: Event): void {
        this.selectedEvent = event;
    }
}
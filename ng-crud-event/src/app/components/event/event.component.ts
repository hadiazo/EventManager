import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-event',
  standalone: true,
  imports: [],
  templateUrl: './event.component.html',
  styleUrl: './event.component.sass'
})
export class EventComponent implements OnInit {
  isUpdate: boolean = false;
  constructor() { 
    
  }
  ngOnInit() {
    console.log("event works!")
  }

  newEvent() {

  }

  save() {
    
  }

  update() {
    
  }
  
  delete(id: any) {
  
  }

  selectItem(item: any) {

  }
  
}

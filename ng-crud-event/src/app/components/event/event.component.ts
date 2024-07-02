import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common'
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { EventModel } from '../../model/eventModel';
import { EventService } from '../../service/event.service';

@Component({
  selector: 'app-event',
  standalone: true,
  imports: [ FormsModule, ReactiveFormsModule, CommonModule ],
  templateUrl: './event.component.html',
  styleUrl: './event.component.sass'
})
export class EventComponent implements OnInit {
  listEvents: EventModel [] = [];
  formEvent: FormGroup = new FormGroup({});
  isUpdate: boolean = false;

  today: string = new Date().toISOString().substring(0,10);
  
  constructor(private eventService: EventService) { }

  ngOnInit(): void {
    this.list();
    this.formEvent =  new FormGroup({
      id: new FormControl(''),
      title: new FormControl(null, Validators.compose([Validators.minLength(1), Validators.required])),
      description: new FormControl(null, Validators.compose([Validators.minLength(1), Validators.required])),
      date: new FormControl(null, [Validators.required]),
      place: new FormControl(null, Validators.compose([Validators.minLength(1), Validators.required])),
      status: new FormControl('1')
    });
    //this.setInitValidators();
  }

  list() {
    this.eventService.getEvents().subscribe(resp=>{
      if(resp) {
        this.listEvents = resp;
      }
    });
  }

  save() {
    this.formEvent.controls['status'].setValue('1');
    this.eventService.saveEvent(this.formEvent.value).subscribe(resp=>{
      if(resp) {
        this.list();
        this.formEvent.reset();
      }
    });
  }

  update() {
    this.eventService.updateEvent(this.formEvent.value).subscribe(resp=>{
      if(resp) {
        this.list();
        this.formEvent.reset();
      }
    });
  }

  delete(id: any) {
    this.eventService.deleteEvent(id).subscribe(resp=>{
      if(resp) {
        this.list();
      }
    });
  }

  newEvent() {
    this.isUpdate = false;
    this.formEvent.reset();
  }

  selectItem(item: any) {
    this.isUpdate = true;
    this.formEvent.controls['id'].setValue(item.id);
    this.formEvent.controls['title'].setValue(item.title);
    this.formEvent.controls['description'].setValue(item.description);
    this.formEvent.controls['date'].setValue(item.date);
    this.formEvent.controls['place'].setValue(item.place);
  }

  /*setInitValidators() {
    this.formEvent.controls['title'].addValidators([Validators.required, Validators.minLength(1)]);
    this.formEvent.controls['description'].addValidators([Validators.required, Validators.minLength(1)]);
    this.formEvent.controls['date'].addValidators([Validators.required]);
    this.formEvent.controls['place'].addValidators([Validators.required, Validators.minLength(1)]);
  }*/

}

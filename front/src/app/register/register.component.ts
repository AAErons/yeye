import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  @Output() childEvent = new EventEmitter();
  signIn(){
    this.childEvent.emit();
  }

}

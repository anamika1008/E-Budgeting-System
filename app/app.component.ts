import { Component } from '@angular/core';
import {NgForm}from '@angular/forms';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  constructor(http: HttpClient) {

  }
  onFormSubmit(myform:NgForm){
    console.log(myform);
  }
}

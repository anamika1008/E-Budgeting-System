import { Component, OnInit } from '@angular/core';
import { DataService } from '../MyServices/dataservices.service';

@Component({
  selector: 'app-adduser',
  templateUrl: './adduser.component.html',
  styleUrls: ['./adduser.component.css']
})
export class AdduserComponent implements OnInit {
  constructor(public ds : DataService) {
   

  }

 

  ngOnInit() {
  }
  onAddUser(empForm){
   
    this.ds.loggingService('this is my mssg');
    this.ds.addNewUser(empForm.value)
    .subscribe((response) =>{
     console.log(response);
   });

  }
}
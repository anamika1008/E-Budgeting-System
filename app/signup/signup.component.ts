import { Component, OnInit } from '@angular/core';
import { DataService } from '../MyServices/dataservices.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(public ds : DataService) {
  }

  ngOnInit() {
  }

resp  
onAddUser(empForm){
    console.log(empForm.value);
    this.ds.addNewUser(empForm.value)
            .subscribe((response) =>{
                  console.log(response);
             });
      }
    }
// onAddUser(empForm){
//   console.log(empForm.value);
 
//   this.ds.loggingService('this is my mssg');
//   this.ds.addNewUser(empForm.value)
//   .subscribe((response) =>{
//     console.log(empForm.value);
//    console.log(response);

//  });


import { Component, OnInit } from '@angular/core';
import { DataService } from '../MyServices/dataservices.service';
import { Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(public route:Router, public ds : DataService) {

   

  }
  ngOnInit() {
  }
  

 resp
 
onSubmit(loginform){
  console.log(loginform.value);
  this.resp=this.ds.getAllEmployees(loginform.value);
 console.log(this.resp);
 
};

onLogin(loginform) {
  console.log(loginform.value);
  this.ds.getAllEmployees(loginform.value)
      .subscribe(
        (response) => {
          console.log(response);
          if(response){
            this.route.navigate(['graph'])       
          }
          else{
            this.route.navigate(['login']) 
          }
        }
      );
   }
}
  
  // if(this.resp==true)
  // this.route.navigate(['chartz']);
  //  }




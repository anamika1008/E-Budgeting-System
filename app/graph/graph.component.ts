import { Component, OnInit } from '@angular/core';
import { DataService } from '../MyServices/dataservices.service';
import { Router} from '@angular/router';

@Component({
  selector: 'app-graph',
  templateUrl: './graph.component.html',
  styleUrls: ['./graph.component.css']
})
export class GraphComponent implements OnInit {

  constructor(public route:Router, public ds : DataService) {

   

  }

  ngOnInit() {
  }

  resp
  onInsert(insert){
    console.log("insert method called");
    
  //   this.resp=this.ds.getAllInsert(insert.value);
  //  console.log(this.resp);
  this.ds.getAllInsert(insert.value)
  .subscribe(
    (response) => {
      console.log(response);
      
    } );
    console.log("Method terminated");


  };

  respo
  onUpdate(Update){
    console.log("updte method called");
    //   this.resp=this.ds.getAllInsert(insert.value);
    //  console.log(this.resp);
    this.ds.getAllUpdate(Update.value)
    .subscribe(
      (response) => {
        console.log(response);
        
      } );
     
  };
  respo2
  onDelete(deletemeth){
    console.log("delete method called");
    //   this.resp=this.ds.getAllInsert(insert.value);
    //  console.log(this.resp);
    this.ds.getAllDelete(deletemeth.value)
    .subscribe(
      (response) => {
        console.log(response);
        
      } );
     
  };
 
}


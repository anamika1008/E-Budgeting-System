import { Component, OnInit } from '@angular/core';
 import { DataService } from '../MyServices/dataservices.service';

@Component({
  selector: 'app-design',
  templateUrl: './design.component.html',
  styleUrls: ['./design.component.css']
})

export class DesignComponent {
  
//   public colors = ['red', 'green', '#0c4172']
// public  dataColumns = [4]; // Single Bar Chart


arr:any=[];
x;



ngOnInit() {

}

public colors = ['red', 'green', 'blue']
public  dataColumns = [1]; // Single Bar Chart


public  barChartData = [{
    id: 0,
    label: '2011',
    value1: null,
    value2: 10,
    value3: 10,
 },{
    id: 1,
    label: '2016',
    value1: 87878,
    value2: 90,
    value3: 10
//  },
//  {
//   id: 1,
//   label: '2016',
//   value1: 4569,
//   value2: 30,
//   value3: 10,
// },
// {
//   id: 1,
//   label: '2016',
//   value1: 4569,
//   value2: 30,
//   value3: 10,
// },
// {
//   id: 1,
//   label: '2016',
//   value1: 4569,
//   value2: 30,
//   value3: 10,
// },
// {
//   id: 1,
//   label: '2016',
//   value1: 4569,
//   value2: 30,
//   value3: 10,
// }
 }];
 constructor(public ds:DataService){
  this.ds.getbarChartData()
.subscribe(
  (response) => {
  this.arr=response;
 console.log(this.arr);

 
  

});

}
this.barChartData[0].value1=this.arr[1];

}




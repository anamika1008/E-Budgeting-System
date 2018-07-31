import { Component, OnInit,Injectable } from '@angular/core';
import { DataService } from '../MyServices/dataservices.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-chart',
  templateUrl: './chart.component.html',
  styleUrls: ['./chart.component.css']
//   // template:`
//   // {{profile|json}}
//   // `
 })


export class ChartComponent implements OnInit {
  public employees:any =[];

  constructor(public route:Router, public ds : DataService) {
    
}

  ngOnInit() {

  }
  
  
  
 
//   public colors = ['red', 'green', '#0c4172']
//   public  dataColumns = [4]; // Single Bar Chart
  
  
//   // public  dataColumns = [3]; // Stacked Bar Chart
//   // public  dataColumns = [2, 1]; //  Multi Stacked Bar Chart
//   public  barChartData = [{
//       id: 0,
//       label: '2010',
//      value1:45    
//    },{
//       id: 1,
//       label: '2011',
//       value1: 70
      
//    },{
//     id: 2,
//     label: '2012',
//     value1: 45
//   },{
//     id: 3,
//     label: '2013',
//     value1: 30
    
//   },{
//     id: 4,
//     label: '2014',
//     value1: 15
    
//   },{
//     id: 5,
//     label: '2015',
//     value1: 65.5
    
//   },{
//     id: 6,
//     label: '2016',
//     value1: 40
    
//   },{
//     id: 7,
//     label: '2017',
//     value1: 10
    
//   },{
//     id: 8,
//     label: '2018',
//     value1: 50
    
//   }]
//   // //public barChartData=this.ds.getChartServe();
}

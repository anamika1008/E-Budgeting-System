import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";

@Injectable()
export class DataService{
    empUrl='http://localhost:8182/signup/UserServlet1';
    emp='http://localhost:8182/signup/LoginServlet';
    chartz='http://localhost:8182/signup/ServeBarGraph';
    chartServe='http://localhost:8182/signup/ServeBarGraph';
    addservice='http://localhost:8182/signup/ConnectLogin';
    deleteservice='http://localhost:8182/signup/Delete';
    updateservice='http://localhost:8182/signup/Update';
    // empUrl='UserServlet1';
    // emp='LoginServlet';
    // chartz='ServeBarGraph';
    // chartServe='ServeBarGraph';
    // addservice='ConnectLogin';
    // deleteservice='Delete';
    // updateservice='Update';

    chartlist
    constructor(public http:HttpClient){

    }
    profile={};
    public addNewUser(emp){
        alert('adding....');
        console.log(emp);
       return this.http.post(this.empUrl,JSON.stringify(emp));

    }
    public getAllEmployees(emp){
        return this.http.post(this.emp,JSON.stringify(emp));
 
     }
     
     public updateEmployee(){
        return this.http.get(this.updateservice,{});

     }

    public loggingService(msg){
        console.log(msg);
    }
    
    public getChartValue(){
        return this.http.post(this.chartz,{});

    }
    public getChartServe(){
        this.http.get(this.chartServe,{}).toPromise().then(data=>{
            return data});
        
    }
    public getAllInsert(emp){
        return this.http.post(this.addservice,JSON.stringify(emp));
        }

    public getAllUpdate(emp){
    return this.http.post(this.updateservice,JSON.stringify(emp));
    }


     public getAllDelete(emp){
     return this.http.post(this.deleteservice,JSON.stringify(emp));
     }
     public getList() {
        // write code to request server
      this.http.get(this.addservice)
                    .subscribe(
                        (response) => {
                           this.chartlist = response;
                        }
                    );
                    return this.chartlist;
    }
    public getbarChartData(){
        return this.http.get(this.addservice);
    }
}
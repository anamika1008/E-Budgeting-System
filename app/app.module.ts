import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule} from '@angular/router';
import { AppComponent } from './app.component';
import { FormComponent } from './form/form.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { DoughnutChartComponent, PieChartComponent ,BarChartComponent} from 'angular-d3-charts'; 
import { ChartComponent } from './chart/chart.component'; // this is needed!
import { AdduserComponent } from './adduser/adduser.component';
import { DataService } from './MyServices/dataservices.service';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import { GraphComponent } from './graph/graph.component';
import { DesignComponent } from './design/design.component';

@NgModule({
  declarations: [
    AppComponent,
    FormComponent,
    HomeComponent,
    LoginComponent,
    SignupComponent,  
    AdduserComponent,
    DoughnutChartComponent, 
   PieChartComponent, 
   BarChartComponent, 
   ChartComponent,
   GraphComponent, DesignComponent ],
  imports: [
    BrowserModule,FormsModule, HttpClientModule,
    RouterModule.forRoot([
      {path:'', component: HomeComponent},
      {path:'login_form',component:FormComponent},
      {path:'login',component:LoginComponent},
      {path:'signup',component:SignupComponent},
       {path:'graph',component:GraphComponent},
       {path:'design',component:DesignComponent}
      
    ]),

  ],
  providers: [DataService, HttpClient],
  bootstrap: [AppComponent]
})
export class AppModule { }

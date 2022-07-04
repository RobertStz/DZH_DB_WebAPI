import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import {AuthServiceGuard} from "./shared/Guards/auth-service.guard";
import {LoginService} from "./shared/login.service";
import { AppLayoutComponent } from './app-layout/app-layout.component';
import { StartseiteComponent } from './startseite/startseite.component';
import { ProfilComponent } from './profil/profil.component';
import { TasksComponent } from './tasks/tasks.component';
import { TimelineComponent } from './timeline/timeline.component';
import { HeaderComponent } from './header/header.component';
import {CitizenService} from "./shared/citizen.service";
import { DecisionComponent } from './decision/decision.component';
import { FooterComponent } from './footer/footer.component';


const myRoutes: Routes = [

  {path: 'index', component:AppLayoutComponent,
    canActivate:[AuthServiceGuard],
    children:[
      {path: '', component: StartseiteComponent},
      {path: 'tasks', component: TasksComponent},
      {path: 'Profile', component: ProfilComponent},
      {path: 'Decision', component: DecisionComponent}
    ]},

  //Login Path
  {path: '', component: LoginComponent},

]

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AppLayoutComponent,
    StartseiteComponent,
    ProfilComponent,
    TasksComponent,
    TimelineComponent,
    HeaderComponent,
    DecisionComponent,
    FooterComponent,

  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(myRoutes),
    HttpClientModule,
  ],
  providers: [LoginService,AuthServiceGuard, CitizenService],
  bootstrap: [AppComponent]
})
export class AppModule { }

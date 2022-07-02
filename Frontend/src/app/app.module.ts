import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {RouterModule, Routes} from "@angular/router";

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import {AuthServiceGuard} from "./shared/Guards/auth-service.guard";
import {LoginService} from "./shared/Services/login.service";
import { AppLayoutComponent } from './app-layout/app-layout.component';
import { StartseiteComponent } from './startseite/startseite.component';
import { ProfilComponent } from './profil/profil.component';
import { TasksComponent } from './tasks/tasks.component';
import { TimelineComponent } from './timeline/timeline.component';
import { HeaderComponent } from './header/header.component';
import { NavbarComponent } from './navbar/navbar.component';

const myRoutes: Routes = [

  //Login Path
  {path: '', component: LoginComponent},

  //SecuredPath
  {path: 'index', component: AppComponent},
  {path: 'home', component: StartseiteComponent},
  {path: 'header', component: HeaderComponent},
  {path: 'navbar', component: NavbarComponent}




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
    HeaderComponent
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(myRoutes),
  ],
  providers: [LoginService,AuthServiceGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }

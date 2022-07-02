import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {RouterModule, Routes} from "@angular/router";

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import {AuthServiceGuard} from "./shared/Guards/auth-service.guard";
import {LoginService} from "./shared/Services/login.service";

const myRoutes: Routes = [

  //Login Path
  {path: '', component: LoginComponent},

  //SecuredPath
  {path: 'index', component: AppComponent},



]

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(myRoutes),
  ],
  providers: [LoginService,AuthServiceGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }

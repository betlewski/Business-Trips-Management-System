import { NgModule } from '@angular/core';
import {Routes} from "@angular/router/src/config";
import {RouterModule} from "@angular/router";
import {LoginComponent} from "./login/login.component";
import {RegisterComponent} from "./register/register.component";
import {HomeComponent} from "./home/home.component";
import {HomePanelComponent} from "./home/home-panel/home-panel.component";
import {EditProfilePanelComponent} from "./home/edit-profile-panel/edit-profile-panel.component";

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  {
    path: 'home',
    component: HomeComponent,
    children: [
      {
        path: '',
        component: HomePanelComponent
      },
      {
        path: 'edit',
        component: EditProfilePanelComponent
      }
    ]
  },
  { path: '', pathMatch:'full', redirectTo: 'login' },
  { path: '**', pathMatch:'full', redirectTo: 'login' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

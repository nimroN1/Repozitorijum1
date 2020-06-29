import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { RegisterComponent } from './components/register/register.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { HotelsComponent } from './components/hotels/hotels.component';


const routes: Routes = [
  {path:'login', component:LoginComponent}, 
  {path:'home', component:HomeComponent}, 
  {path:'register', component:RegisterComponent}, 
  {path:'hotels', component:HotelsComponent}, 
/*   {path:'articles/:id', component:ArticlesComponent}, 
  {
    path:'about', 
    component:AboutComponent, 
    children:[
      {path:'about-admin', component:AboutAdminComponent}
    ]
  }, */
  {path:'', redirectTo:'/home', pathMatch:'full'}, 
  {path:'**', component:PageNotFoundComponent}, 
  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

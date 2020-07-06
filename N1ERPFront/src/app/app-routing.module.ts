import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { RegisterComponent } from './components/register/register.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { HotelsComponent } from './components/hotels/hotels.component';
import { HotelComponent } from './components/hotel/hotel.component';
import { HotelsAdminComponent } from './components/hotels-admin/hotels-admin.component';
import { HotelsAdminUpdateComponent } from './components/hotels-admin-update/hotels-admin-update.component';


const routes: Routes = [
  {path:'login', component:LoginComponent}, 
  {path:'home', component:HomeComponent}, 
  {path:'register', component:RegisterComponent}, 
  {path:'hotels', component:HotelsComponent}, 
  {path:'hotels-admin', component:HotelsAdminComponent}, 
  {path:'hotels-admin-update/:id', component:HotelsAdminUpdateComponent}, 
  {path:'hotel/:id', component:HotelComponent},  
  {path:'', redirectTo:'/home', pathMatch:'full'}, 
  {path:'**', component:PageNotFoundComponent} 
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

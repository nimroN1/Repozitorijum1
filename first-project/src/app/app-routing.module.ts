import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ArticlesComponent } from './articles/articles.component';
import { AboutComponent } from './about/about.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AboutAdminComponent } from './about/about-admin/about-admin.component';


const routes: Routes = [
  {path:'login', component:LoginComponent}, 
  {path:'articles/:id', component:ArticlesComponent}, 
  {
    path:'about', 
    component:AboutComponent, 
    children:[
      {path:'about-admin', component:AboutAdminComponent}
    ]
  },
  {path:'', redirectTo:'/login', pathMatch:'full'}, 
  {path:'**', component:PageNotFoundComponent}, 
  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
  
}

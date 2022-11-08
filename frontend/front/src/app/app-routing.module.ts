import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ProductListComponent } from './components/pages/product-list/product-list.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: '', redirectTo: "home" , pathMatch: 'full'},
  {path: 'product', component: ProductListComponent }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

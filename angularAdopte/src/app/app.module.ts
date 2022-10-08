import { routes } from './routes';
import { AuthInterceptor } from './interceptor/auth.interceptor';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ConnexionComponent } from './component/connexion/connexion.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { UtilisateurConnecteComponent } from './component/utilisateur-connecte/utilisateur-connecte.component';
import { RouterModule } from '@angular/router';
import { ConnexionAdminComponent } from './component/connexion-admin/connexion-admin.component';
import { AdminConnecteComponent } from './component/admin-connecte/admin-connecte.component';
import { UploadSonComponent } from './component/upload-son/upload-son.component';
import { RefusComponent } from './component/refus/refus.component';

@NgModule({
  declarations: [AppComponent, ConnexionComponent, UtilisateurConnecteComponent, ConnexionAdminComponent, AdminConnecteComponent, UploadSonComponent, RefusComponent],
  imports: [BrowserModule, HttpClientModule, FormsModule,RouterModule.forRoot(routes) ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}

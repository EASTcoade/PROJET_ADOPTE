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
import { MenuAdminComponent } from './component/menu-admin/menu-admin.component';
import { ListeInstrumentComponent } from './component/liste-instrument/liste-instrument.component';
import { ContenuAdminComponent } from './component/contenu-admin/contenu-admin.component';
import { InscriptionComponent } from './component/inscription/inscription.component';
import { HomeComponent } from './component/home/home.component';
import { ChatComponent } from './component/chat/chat.component';

@NgModule({
  declarations: [AppComponent, ConnexionComponent, UtilisateurConnecteComponent, ConnexionAdminComponent, AdminConnecteComponent, UploadSonComponent, RefusComponent, MenuAdminComponent, ListeInstrumentComponent, ContenuAdminComponent, InscriptionComponent, HomeComponent, ChatComponent],
  imports: [BrowserModule, HttpClientModule, FormsModule,RouterModule.forRoot(routes) ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}

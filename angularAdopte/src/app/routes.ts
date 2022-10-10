import { ChatComponent } from './component/chat/chat.component';
import { Chat } from 'src/app/model/chat';
import { HomeComponent } from './component/home/home.component';
import { ContenuAdminComponent } from './component/contenu-admin/contenu-admin.component';
import { ListeInstrumentComponent } from './component/liste-instrument/liste-instrument.component';
import { Component } from '@angular/core';
import { RefusComponent } from './component/refus/refus.component';
import { AnonymousGuardService } from './service/guard/anonymous-guard.service';
import { UserGuardService } from './service/guard/user-guard.service';
import { AdminGuardService } from './service/guard/admin-guard.service';
import { UploadSonComponent } from './component/upload-son/upload-son.component';
import { ConnexionAdminComponent } from './component/connexion-admin/connexion-admin.component';
import { AdminConnecteComponent } from './component/admin-connecte/admin-connecte.component';
import { UtilisateurConnecteComponent } from './component/utilisateur-connecte/utilisateur-connecte.component';
import { ConnexionComponent } from './component/connexion/connexion.component';
import { Routes } from '@angular/router';
import { InscriptionComponent } from './component/inscription/inscription.component';
import { StyleMusicauxComponent } from './component/style-musicaux/style-musicaux.component';

export const routes: Routes = [
  {
    path: 'style-musicaux',
    component:StyleMusicauxComponent,
    canActivate:[UserGuardService],
  },

  {
    path: 'connexion',
    component: ConnexionComponent,
    canActivate: [AnonymousGuardService],
  },
  {
    path: 'inscription',
    component: InscriptionComponent,
    canActivate: [AnonymousGuardService],
  },
  {
    path: 'home',
    component: HomeComponent,
    canActivate: [AnonymousGuardService],
  },
  {
    path: 'chat',
    component: ChatComponent,

  },
  {
    path: 'connexion/admin',
    component: ConnexionAdminComponent,
    canActivate: [AnonymousGuardService],
  },

  {
    path: 'utilisateur',
    component: UtilisateurConnecteComponent,
    canActivate: [UserGuardService],
  },
  {
    path: 'admin',
    component: AdminConnecteComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'upload-son',
    component: UploadSonComponent,
  },
  {
    path: 'refus',
    component: RefusComponent,
  },
  {
    path: 'instrument',
    component: ListeInstrumentComponent,
  },
  {
    path: 'contenu',
    component: ContenuAdminComponent,
    outlet: 'pageAdminContenu',
  },
  {
    path: '',
    redirectTo: 'connexion',
    pathMatch: 'full',
  },
];

import { SonsComponent } from './component/sons/sons.component';
import { EditStyleComponent } from './component/edit-style/edit-style.component';
import { ListeStyleComponent } from './component/liste-style/liste-style.component';
import { RechercheComponent } from './component/recherche/recherche.component';
import { DetailUtilisateurComponent } from './component/detail-utilisateur/detail-utilisateur.component';
import { PhotoProfilComponent } from './component/photo-profil/photo-profil.component';
import { ChatAppComponent } from './component/chat-app/chat-app.component';
import { AffichageImageComponent } from './component/affichage-image/affichage-image.component';
import { EditInstrumentComponent } from './component/edit-instrument/edit-instrument.component';
import { ListeUtilisateurComponent } from './component/liste-utilisateur/liste-utilisateur.component';
// import { LectureSonComponent } from './component/lecture-son/lecture-son.component';

import { ChoixInstrumentComponent } from './component/choix-instrument/choix-instrument.component';
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
import { LectureSonComponent } from './component/lecture-son/lecture-son.component';

export const routes: Routes = [
  {
    path: 'choix-instrument',
    component: ChoixInstrumentComponent,
    canActivate: [UserGuardService],
  },
  {
    path: 'style-musicaux',
    component: StyleMusicauxComponent,
    canActivate: [UserGuardService],
  },
  {
    path: 'choix-photo',
    component: PhotoProfilComponent,
    canActivate: [UserGuardService],
  },

  {
    path: 'chat',
    component: ChatAppComponent,
    canActivate: [UserGuardService],
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
    canActivate: [UserGuardService],
  },
  {
    path: 'refus',
    component: RefusComponent,
  },
  {
    path: 'instrument',
    component: ListeInstrumentComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'contenu',
    component: ContenuAdminComponent,
  },
  {
    path: 'lecture-son',
    component: LectureSonComponent,
  },
  {
    path: 'utilisateurs',
    component: ListeUtilisateurComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'affichage-image',
    component: AffichageImageComponent,
  },
  {
    path: 'instrument/add',
    component: EditInstrumentComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'detail-utilisateur/:id',
    component: DetailUtilisateurComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'recherche',
    component: RechercheComponent,
    canActivate: [UserGuardService],
  },
  {
    path: 'styles',
    component: ListeStyleComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'style/add',
    component: EditStyleComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'sons/:id',
    component: SonsComponent,
    canActivate: [UserGuardService],
  },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full',
  },
];

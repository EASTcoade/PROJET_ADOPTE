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

export const routes: Routes = [
  {
    path: 'connexion',
    component: ConnexionComponent,
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
  },
  {
    path: 'refus',
    component: RefusComponent,
  },
  {
    path: '',
    redirectTo: 'connexion',
    pathMatch: 'full',
  },
];

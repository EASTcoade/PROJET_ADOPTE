import { ConnexionAdminComponent } from './component/connexion-admin/connexion-admin.component';
import { AdminConnecteComponent } from './component/admin-connecte/admin-connecte.component';
import { UtilisateurConnecteComponent } from './component/utilisateur-connecte/utilisateur-connecte.component';
import { ConnexionComponent } from './component/connexion/connexion.component';
import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: 'connexion',
    component: ConnexionComponent,
  },
  {
    path: 'connexion/admin',
    component: ConnexionAdminComponent,
  },

  {
    path: 'utilisateur',
    component: UtilisateurConnecteComponent,
  },
  {
    path: 'admin',
    component: AdminConnecteComponent,
  },
  {
    path: '',
    redirectTo: 'connexion',
    pathMatch: 'full',
  },
];

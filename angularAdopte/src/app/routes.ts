import { UtilisateurConnecteComponent } from './component/utilisateur-connecte/utilisateur-connecte.component';
import { ConnexionComponent } from './component/connexion/connexion.component';
import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: 'connexion',
    component: ConnexionComponent,
  },
  {
    path: 'utilisateur',
    component: UtilisateurConnecteComponent,
  },
  {
    path: '',
    redirectTo: 'connexion',
    pathMatch: 'full',
  },
];

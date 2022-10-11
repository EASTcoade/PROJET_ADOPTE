import { AuthAdminService } from 'src/app/service/auth-admin.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menu-admin',
  templateUrl: './menu-admin.component.html',
  styleUrls: ['./menu-admin.component.css'],
})
export class MenuAdminComponent implements OnInit {
  infoCompte: string = '';
  roleAdmin = false;
  constructor(private authAdminService: AuthAdminService) {}

  ngOnInit(): void {
    let compte = JSON.parse(sessionStorage.getItem('compte')!);
    if (compte.username) {
      this.infoCompte =
        'Bienvenue admin id #' + compte.id + ' : ' + compte.username;
    }
  }
  logout() {
    this.authAdminService.logout();
  }
}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthAdminService } from 'src/app/service/auth-admin.service';


@Component({
  selector: 'app-connexion-admin',
  templateUrl: './connexion-admin.component.html',
  styleUrls: ['./connexion-admin.component.css']
})
export class ConnexionAdminComponent implements OnInit {
  username: string = '';
  password: string = '';
  constructor(private srvAuth: AuthAdminService, private router: Router) {}

  ngOnInit(): void {}

  send() {
    this.srvAuth.authentification(this.username, this.password).subscribe({
      next: (data: any) => {
        sessionStorage.setItem('compte', JSON.stringify(data));
        sessionStorage.setItem(
          'token',
          'BASIC ' + btoa(this.username + ':' + this.password)
        );
        this.router.navigateByUrl('/admin');
      },
      error: (err: any) => {
        console.log(err);
        // this.msg = 'Informations incorrectes !';
        // this.afficheMsg = true;
      },
    });
  }
}

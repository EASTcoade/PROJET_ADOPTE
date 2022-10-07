import { Router } from '@angular/router';
import { AuthService } from './../../service/auth.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css'],
})
export class ConnexionComponent implements OnInit {
  username: string = '';
  password: string = '';
  constructor(private srvAuth: AuthService, private router: Router) {}

  ngOnInit(): void {}

  send() {
    this.srvAuth.authentification(this.username, this.password).subscribe({
      next: (data) => {
        sessionStorage.setItem('compte', JSON.stringify(data));
        sessionStorage.setItem(
          'token',
          'BASIC ' + btoa(this.username + ':' + this.password)
        );
        this.router.navigateByUrl('/utilisateur');
      },
      error: (err) => {
        console.log(err);
        // this.msg = 'Informations incorrectes !';
        // this.afficheMsg = true;
      },
    });
  }
}

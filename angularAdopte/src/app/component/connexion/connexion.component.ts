import { AuthService } from './../../service/auth.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css'],
})
export class ConnexionComponent implements OnInit {
  username: string = '';
  password: string = '';
  place = false;
  constructor(private srvAuth: AuthService, private router: Router) {}

  ngOnInit(): void {}

  send() {
    this.srvAuth.authentification(this.username, this.password).subscribe({
      next: (data: any) => {
        sessionStorage.setItem('compte', JSON.stringify(data));
        sessionStorage.setItem(
          'token',
          'BASIC ' + btoa(this.username + ':' + this.password)
        );
        sessionStorage.setItem('role', 'ROLE_USER');
        this.router.navigateByUrl('/utilisateur');
      },
      error: (err: any) => {
        // console.log(err);
        this.place = true;
        this.username = '';
        this.password = '';
      },
    });
  }
}

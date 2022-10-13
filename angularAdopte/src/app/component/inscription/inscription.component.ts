import { Router, RouterModule } from '@angular/router';
import { AuthService } from './../../service/auth.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  form: any = {
    username: null,
    password: null,
    nom: null,
    prenom: null,
    mail: null,
    adresse: null,
    telephone: null,
    niveau: null,
    dateNaissance: null,
  };

  constructor(private srvAuth: AuthService, private router: Router) {}

  ngOnInit(): void {}

  get f() {
    return this.form.controls;
  }

  onSubmit() {
    this.srvAuth
      .register(this.form)
      .pipe(first())
      .subscribe({
        next: (data) => {
          // console.log(data);
          this.srvAuth
            .authentification(this.form.username, this.form.password)
            .subscribe({
              next: (data: any) => {
                sessionStorage.setItem('compte', JSON.stringify(data));
                sessionStorage.setItem(
                  'token',
                  'BASIC ' + btoa(this.form.username + ':' + this.form.password)
                );
                sessionStorage.setItem('role', 'ROLE_USER');
                console.log('session ok');
                this.router.navigateByUrl('/choix-photo');
              },
              error: (err: any) => {
                console.log(err);
                // this.msg = 'Informations incorrectes !';
                // this.afficheMsg = true;
              },
            });
        },
        error: (error) => console.log(error),
      });
    // this.router.navigate(['choix-photo']);
  }
}

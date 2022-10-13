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
  placeNom = false;
  placePrenom = false;
  placeMail = false;
  placeUsername = false;
  placeDateNaissance = false;
  placePassword = false;
  placeAdresse = false;
  placeTelephone = false;
  placeNiveau = false;

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
    if (!this.form.nom || this.form.nom == '') {
      this.placeNom = true;
      return;
    }
    if (!this.form.prenom || this.form.prenom == '') {
      this.placePrenom = true;
      return;
    }
    if (!this.form.mail || this.form.mail == '') {
      this.placeMail = true;
      return;
    }
    if (!this.form.username || this.form.username == '') {
      this.placeUsername = true;
      return;
    }
    if (
      !this.form.dateNaissance ||
      this.form.dateNaissance == '' ||
      this.form.dateNaissance >= new Date()
    ) {
      this.placeDateNaissance = true;
      return;
    }
    if (!this.form.password || this.form.password == '') {
      this.placePassword = true;
      return;
    }
    if (!this.form.adresse || this.form.adresse == '') {
      this.placeAdresse = true;
      return;
    }
    if (!this.form.telephone || this.form.telephone == '') {
      this.placeTelephone = true;
      return;
    }
    if (!this.form.niveau || this.form.niveau == '') {
      this.placeNiveau = true;
      return;
    }
    console.log('ça passe');
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
  }
}

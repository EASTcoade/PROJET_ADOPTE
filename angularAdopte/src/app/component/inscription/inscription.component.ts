import { Router, RouterModule } from '@angular/router';
import { AuthService } from './../../service/auth.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
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

  constructor(private srvAuth: AuthService, private router: Router) { }

  ngOnInit(): void  {};


    get f() {return this.form.controls;}

    onSubmit() {

      this.srvAuth.register(this.form).pipe(first()).subscribe(
        data =>{
        console.log(data);
        this.router.navigate(['home'])
      },
      error => console.log(error));
    }
;
    }



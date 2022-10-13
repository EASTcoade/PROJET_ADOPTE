import { HttpClient } from '@angular/common/http';
import { StyleMusicalService } from 'src/app/service/crud-style-musical/style-musical.service';
import { ActivatedRoute, Router } from '@angular/router';
import { StyleMusical } from './../../model/style-musical';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-edit-style',
  templateUrl: './edit-style.component.html',
  styleUrls: ['./edit-style.component.css'],
})
export class EditStyleComponent implements OnInit {
  style: StyleMusical = new StyleMusical();
  placeNom = false;
  constructor(
    private activatedRoute: ActivatedRoute,
    private srvStyle: StyleMusicalService,
    private router: Router,
    private httpClient: HttpClient
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.srvStyle.getById(params['id']).subscribe((data) => {
          this.style = data;
        });
      }
    });
  }

  save() {
    if (this.style.id) {
      //update
    } else {
      if (!this.style.nom || this.style.nom == '') {
        this.placeNom = true;
      } else {
        this.srvStyle.create(this.style).subscribe((data) => {
          this.router.navigateByUrl('/styles');
        });
      }
    }
  }
}

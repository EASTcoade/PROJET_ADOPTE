import { StyleMusicalService } from 'src/app/service/crud-style-musical/style-musical.service';
import { StyleMusical } from 'src/app/model/style-musical';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-liste-style',
  templateUrl: './liste-style.component.html',
  styleUrls: ['./liste-style.component.css'],
})
export class ListeStyleComponent implements OnInit {
  styles!: Observable<StyleMusical[]>;
  constructor(private srvStyle: StyleMusicalService) {}

  ngOnInit(): void {
    this.styles = this.srvStyle.getAll();
  }
}

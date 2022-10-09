import { Observable } from 'rxjs';
import { InstrumentService } from './../../service/crud-instrument/instrument.service';
import { Component, OnInit } from '@angular/core';
import { Instrument } from 'src/app/model/instrument';

@Component({
  selector: 'app-liste-instrument',
  templateUrl: './liste-instrument.component.html',
  styleUrls: ['./liste-instrument.component.css'],
})
export class ListeInstrumentComponent implements OnInit {
  instruments!: Observable<Instrument[]>;
  constructor(private srvInstrument: InstrumentService) {}

  ngOnInit(): void {
    this.instruments = this.srvInstrument.getAll();
  }
}

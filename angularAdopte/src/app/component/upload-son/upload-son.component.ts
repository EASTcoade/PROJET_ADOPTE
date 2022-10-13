import { Son } from './../../model/son';
import { SonService } from './../../service/crud-son/son.service';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-upload-son',
  templateUrl: './upload-son.component.html',
  styleUrls: ['./upload-son.component.css'],
})
export class UploadSonComponent {
  fileName = '';
  monFormData = new FormData();
  msgReussite = 'Son enregistré !';
  afficheMsg = false;
  constructor(private httpClient: HttpClient, private srvSon: SonService) {}

  onFileSelected(event: any) {
    const file: File = event.target.files[0];
    if (file) {
      this.fileName = file.name;
      // const formData = new FormData();
      // formData.append('file', file);
      // formData.append('titre', this.fileName);
      // formData.append(
      //   'createur',
      //   JSON.parse(sessionStorage.getItem('compte')!).id
      // );
      // formData.append('format', this.fileName.split('.')[1].toUpperCase());
      this.monFormData.append('file', file);
      this.monFormData.append('titre', file.name);
      this.monFormData.append(
        'createur',
        JSON.parse(sessionStorage.getItem('compte')!).id
      );
      this.monFormData.append(
        'format',
        this.fileName.split('.')[1].toUpperCase()
      );
    }
  }
  EnregistrerSon() {
    console.log(this.monFormData.get('titre'));
    const upload$ = this.httpClient.post(
      'http://localhost:8080/adopte/api/son',
      this.monFormData
    );
    upload$.subscribe(() => {
      this.afficheMsg = true;
    });
  }
}

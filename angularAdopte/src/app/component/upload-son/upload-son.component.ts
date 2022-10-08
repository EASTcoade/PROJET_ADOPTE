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

  constructor(private httpClient: HttpClient, private srvSon: SonService) {}

  onFileSelected(event: any) {
    const file: File = event.target.files[0];
    // if (file) {
    // this.fileName = file.name;
    // const formData = new FormData();
    // formData.append('thumbnail', file);
    // const upload$ = this.httpClient.post('/api/thumbnail-upload', formData);
    // upload$.subscribe();
    this.fileName = file.name;

    console.log(file.arrayBuffer());
    file.arrayBuffer().then((buff) => {
      let x = new Uint8Array(buff);
      console.log(x);
      //mapping du son
      let son = {
        titre: file.name,
        contenu: x,
        format: file.name.split('.')[1],
      };
      Object.assign(son, {
        createur: { id: JSON.parse(sessionStorage.getItem('compte')!).id },
      });
      this.srvSon.create(son).subscribe(() => {
        console.log('son enregistré !');
      });
    });
    console.log('call finished');
    // }
  }
}

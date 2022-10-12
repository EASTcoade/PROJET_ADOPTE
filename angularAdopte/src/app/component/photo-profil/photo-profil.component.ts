import { UtilisateurService } from './../../service/crud-uti/utilisateur.service';
import { Component, OnInit } from '@angular/core';
import { Utilisateur } from 'src/app/model/utilisateur';
import { ImageService } from 'src/app/service/crud-image/image.service';

@Component({
  selector: 'app-photo-profil',
  templateUrl: './photo-profil.component.html',
  styleUrls: ['./photo-profil.component.css']
})
export class PhotoProfilComponent implements OnInit {


  monFormData = new FormData();
  id!: number;


  constructor(
    private srvImage: ImageService,
    private srvUti: UtilisateurService
  ) { }

  ngOnInit(): void {
     this.id = JSON.parse(sessionStorage.getItem('compte')!).id ;
  }

  public onFileSelected(event: any) {
    const file: File = event.target.files[0];
    if (file) {
      this.monFormData.append('file', file);
      this.monFormData.append('titre', file.name.split('.')[0]);
      this.monFormData.append('format', file.name.split('.')[1].toUpperCase());
    }
  }
  public EnregistrerImage() {
    console.log(this.monFormData.get('titre'));
    const laConst = this.srvImage.create(this.monFormData);
    laConst.subscribe((data) => {

      console.log('requete!!!!!: '+data )
      if (data.id){
      this.srvUti.putImage(this.id, data.id).subscribe(()=>{console.log('terminer')})} ;
    });
  }

}

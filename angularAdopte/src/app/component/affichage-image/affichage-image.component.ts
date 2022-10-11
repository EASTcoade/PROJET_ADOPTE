import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { ImageService } from 'src/app/service/crud-image/image.service';

@Component({
  selector: 'app-affichage-image',
  templateUrl: './affichage-image.component.html',
  styleUrls: ['./affichage-image.component.css'],
})
export class AffichageImageComponent implements OnInit {
  contenu!: Observable<any[]>;
  titre: string | undefined;
  constructor(private srvImage: ImageService) {}

  ngOnInit(): void {
    this.srvImage.getByIdToRead(4).subscribe((data) => {
      this.contenu = data.contenu;
    });
  }
}

import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { UtilisateurService } from 'src/app/service/crud-uti/utilisateur.service';
import { Component, OnInit } from '@angular/core';
import { ChatMessage } from 'src/app/model/chat-message';
import { Utilisateur } from 'src/app/model/utilisateur';
import { MessagesService } from 'src/app/service/messages.service';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-utilisateur-connecte',
  templateUrl: './utilisateur-connecte.component.html',
  styleUrls: ['./utilisateur-connecte.component.css'],
})
export class UtilisateurConnecteComponent implements OnInit {
  constructor(
    private messageService: MessagesService,
    private srvUtilisateur: UtilisateurService,
    private authService: AuthService,
    private router: Router
  ) {}
  utilisateur!: Utilisateur;
  id!: number;
  model = new ChatMessage('');

  messageList: string[] = [];

  sendMessage(): void {
    console.log(this.model.msg);
    this.messageService.sendMessage(this.model.msg);
    this.model.msg = '';
  }

  ngOnInit(): void {
    this.messageService.getMessage().subscribe((message: string) => {
      this.messageList.push(message);
    });

    this.id = JSON.parse(sessionStorage.getItem('compte')!).id;
    this.srvUtilisateur.getByIdFetchAll(this.id).subscribe((data) => {
      this.utilisateur = data;
    });
  }

  submitted = false;

  onSubmit() {
    this.sendMessage();
    this.submitted = true;
  }

  logout() {
    this.authService.logout();
  }

  changerImage() {
    this.router.navigateByUrl('/choix-photo');
  }
}

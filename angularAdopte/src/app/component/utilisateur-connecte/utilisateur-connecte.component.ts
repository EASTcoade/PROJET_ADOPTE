import { Component, OnInit } from '@angular/core';
import { ChatMessage } from 'src/app/model/chat-message';
import { MessagesService } from 'src/app/service/messages.service';

@Component({
  selector: 'app-utilisateur-connecte',
  templateUrl: './utilisateur-connecte.component.html',
  styleUrls: ['./utilisateur-connecte.component.css'],
})
export class UtilisateurConnecteComponent implements OnInit {
  constructor(private messageService: MessagesService) {}

  model = new ChatMessage("");

  messageList: string[] = [];

  sendMessage(): void {
    console.log(this.model.msg)
    this.messageService.sendMessage(this.model.msg)
    this.model.msg = "";
  };

  ngOnInit(): void {this.messageService.getMessage().subscribe((message:string)=> {
    this.messageList.push(message);
  })}

  submitted = false;

  onSubmit() {
    this.sendMessage()
    this.submitted = true;


   }

}

import { Component } from '@angular/core';


import { ChatMessage } from 'src/app/model/chat-message';
import { MessagesService } from 'src/app/service/messages.service';

@Component({
  selector: 'app-chat-app',
  templateUrl: './chat-app.component.html',
  styleUrls: ['./chat-app.component.css']
})
export class ChatAppComponent {

  constructor(private messageService: MessagesService) {}

  model = new ChatMessage("");

  messageList: string[] = [];

  sendMessage(): void {
    console.log(this.model.msg)
    this.messageService.sendMessage(this.model.msg)
    this.model.msg = "";
  };

ngOnInit(): void {
  this.messageService.getMessage().subscribe((message:string)=> {
    this.messageList.push(message);
  })
}

  submitted = false;

  onSubmit() {
    this.sendMessage()
    this.submitted = true;

   }
}

import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  roleAdmin = false;
  title = 'angularAdopte';

  public getRole(): boolean {
    if (sessionStorage.getItem('role')) {
      if (sessionStorage.getItem('role') == 'ROLE_ADMIN') {
        return true;
      }
    }
    return false;
  }
}

import { Component } from '@angular/core';
import {AnnouncementComponent} from './components/announcement/announcement.component';
import {HeaderComponent} from './components/header/header.component';
import {LoginFormComponent} from './components/login-form/login-form.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  imports: [
    AnnouncementComponent,
    HeaderComponent,
    LoginFormComponent
  ],
  styleUrls: ['./app.component.scss']
})
export class AppComponent {}

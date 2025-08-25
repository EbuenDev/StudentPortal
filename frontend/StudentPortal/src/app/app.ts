import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {HeaderComponent} from './components/header/header.component';
import {AnnouncementComponent} from './components/announcement/announcement.component';
import {LoginFormComponent} from './components/login-form/login-form.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, HeaderComponent, AnnouncementComponent, LoginFormComponent],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected readonly title = signal('StudentPortal');
}

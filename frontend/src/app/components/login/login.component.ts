import { Component } from '@angular/core';
import { InputTextModule } from 'primeng/inputtext';
import { FloatLabelModule } from 'primeng/floatlabel';
import { FormsModule } from '@angular/forms';
import { PasswordModule } from 'primeng/password';
import { NgOptimizedImage } from '@angular/common';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [InputTextModule,FloatLabelModule,FormsModule,PasswordModule,NgOptimizedImage],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  email: string = "";
  password: string = "";

  onLogin() {
    
  }
}

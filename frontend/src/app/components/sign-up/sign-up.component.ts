import { Component } from '@angular/core';
import { NgOptimizedImage } from '@angular/common';
import { InputTextModule } from 'primeng/inputtext';
import { FloatLabelModule } from 'primeng/floatlabel';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-sign-up',
  standalone: true,
  imports: [NgOptimizedImage,InputTextModule,FloatLabelModule,FormsModule],
  templateUrl: './sign-up.component.html',
  styleUrl: './sign-up.component.css'
})
export class SignUpComponent {
  name: string = "";
  email: string = "";
  cro: string = "";
  speciality: string = "";
  password: string = "";
  passwordConfirm: string = "";
}

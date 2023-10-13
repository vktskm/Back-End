import { Component, OnInit } from '@angular/core';
import { ISignupData } from 'src/app/interfaces/isignup-data';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-table-user',
  templateUrl: './table-user.component.html',
  styleUrls: ['./table-user.component.css']
})
export class TableUserComponent implements OnInit {

  users: ISignupData[] = [];

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
    this.authService.getUsers().subscribe(ele => this.users = ele);
  }

}

import { Injectable, Component, OnInit } from '@angular/core';
import { ReportBackendService } from '../../services/reportBackend.service';
import { User } from '../../model/report.model';
import { Router } from '@angular/router';

@Component({
    selector: 'login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
    ngOnInit() { }

    constructor(
        private reportBackend: ReportBackendService,
        private router: Router) { }

    userFromJson(json) {
        return {
            nickname: json['nickname'],
            password: json['password'],
            name: json['name'],
            email: json['email'],
            phoneNumber: json['phoneNumber'],
            userType: json['userType']
        }
    }

    title = 'login';

    user: User = {
        nickname: "",
        password: "", 
        name: "",
        email: "", 
        phoneNumber: "",
        userType: ""
    };

    login() {
        /*this.reportBackend.login(this.user).subscribe(response => {
            if (response != null) { //;sikerült bejelentkezni
                this.reportBackend.user = this.userFromJson(response);*/
                this.router.navigate(['/report']);
            /*}
            else {
                alert("Hibás felhasználónév/email vagy jelszó!");
            }
        }, err => {
        });*/
    }
}
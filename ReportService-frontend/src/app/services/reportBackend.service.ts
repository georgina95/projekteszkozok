import { Injectable } from '@angular/core';
import { User, Report, State } from '../model/report.model';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { tap } from "rxjs/operators";

const BASE_URL = "http://localhost:4200/";

const httpOptions = {
    headers: new HttpHeaders(
        {'Content-Type': 'application/json'}
    )
};

@Injectable()
export class ReportBackendService {
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

    user: User = {
        nickname: "",
        password: "", 
        name: "",
        email: "", 
        phoneNumber: "",
        userType: ""
    };

    constructor(private http: HttpClient) { }

    init() {
        this.user = {
            nickname: "Ismeretlen",
            password: "",
            name: "",
            email: "",
            phoneNumber: "",
            userType: ""
        };
    }

    login(user: User) {
        this.get<string>(BASE_URL + 'user/login', user);
        return this.post<User>(BASE_URL + 'user/login', user);
    }

    get<TResponse>(action: string, params: any) {
        let url = action + '?' + Object.keys(params).map(key => key + '=' + params[key]).join('&');
        return this.http.get<TResponse>(url);
    }

    post<TResponse>(action: string, params: any) {
        let url = action + '?' + Object.keys(params).map(key => key + '=' + params[key]).join('&');
        return this.http.post<TResponse>(url, {});
    }
}

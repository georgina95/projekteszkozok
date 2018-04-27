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
        id: json['id'],
        email: json['email'],
        password: json['password'],
        nickname: json['nickname'],
        userType: json['userType'],
        name: json['name'],
        phoneNumber: json['phoneNumber'],
        states: json['states']
        }
    }

    // get-post es tarsai, akar default beallitasok vendeg eseten, 
    // ha akarjuk, de az maceras szerintem
}

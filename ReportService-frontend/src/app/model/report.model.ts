import { Data } from "@angular/router/src/config";

export interface User {
    nickname: string;
    password: string;
    name: string;
    email: string;
    phoneNumber: string;
    userType: string;
}

export interface Report {
    id: number;
    reportDate: Date;
    reporter: User;
    operator: User;
    status: string;
    report: Report;
}

export interface State {
    id: number;
    triggeredBy: User;
    owner: string;
    stateDate: Date;
    status: string;
    report: Report;
}
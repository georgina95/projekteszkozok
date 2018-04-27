import { Data } from "@angular/router/src/config";

export interface User {
    id: number;
    nickname: string;
    name: string;
    email: string;
    phoneNumber: string;
    userType: string;
    [states: number]: { state: State };
}

export interface Report {
    id: number;
    reportDate: Date;
    reporter: User;
    operator: User;
    status: string;
    report: Report;
    [states: number]: { state: State };
}

export interface State {
    id: number;
    triggeredBy: User;
    owner: string;
    stateDate: Date;
    status: string;
    report: Report;
}
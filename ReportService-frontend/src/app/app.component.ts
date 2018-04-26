import { Injectable, Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
// import { ReportBackendService } from "./services/reportBackend.service";

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})

@Injectable()
export class AppComponent {
    constructor(
        // private backendService: ReportBackendService,
        private router: Router
    ) { }

    home() {
        this.router.navigate(['/home']);
    }

    login() {
        this.router.navigate(['/login']);
    }

    report() {
        this.router.navigate(['/report']);
    }
}

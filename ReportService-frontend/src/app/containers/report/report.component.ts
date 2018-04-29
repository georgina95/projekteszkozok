import { Injectable, Component, OnInit } from '@angular/core';
import { ReportBackendService } from '../../services/reportBackend.service';
import { Report } from '../../model/report.model';
import { Router } from '@angular/router';

@Component({
    selector: 'report',
    templateUrl: './report.component.html',
    styleUrls: ['./report.component.css']
})

export class ReportComponent implements OnInit {
    ngOnInit() { }

    constructor(
        private reportBackend: ReportBackendService,
        private router: Router) { }

    
    title = 'reports';
    reports: Report[];
}
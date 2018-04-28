import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes }   from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { ReportBackendService } from './services/reportBackend.service';

import { AppComponent } from './app.component';
import { LoginComponent } from './containers/login/login.component';
import { ReportComponent } from './containers/report/report.component';

const routes: Routes = [
    {
        path: '',
        component: AppComponent
    },
    {
        path: 'login',
        component: LoginComponent
    },
    {
        path: 'report',
        component: ReportComponent
    }
];

@NgModule({
    declarations: [
        LoginComponent,
        ReportComponent,
        AppComponent
    ],
    imports: [
        BrowserModule,
        RouterModule.forRoot(routes),
        FormsModule,
        HttpClientModule
    ],
    providers: [/*ReportBackendService*/],
    bootstrap: [AppComponent]
})

export class AppModule { }

import { Injectable } from '@angular/core';

 @Injectable()
 export class AppConfigService {
     private apiUrl: string = "http://localhost:8080/api/";
     private apiUser: string = "MORINLUCILE";
     private apiPassword: string = "123456";

     public getApiUrl(): string {
         return this.apiUrl;
     }

     public getApiBasic(): string {
         return 'Basic ' + btoa(this.apiUser + ':' + this.apiPassword);
     }
 }

# 📑 Angular how to send data from one component to another

- **🏷️Tags** : #27-04-2022, #review, #angular #pending

#### 🔗 Links
[link](https://www.dotnettricks.com/learn/angular/sharing-data-between-angular-components-methods)


## Key Takeaways

## Overview
1. Parent to Child : via Input
2. Child to Parent : Output and EventEmitter
3. Child to Parent : via ViewChild
4. Unrelated Component : via a service 




### Parent to Child
1. `@Input` will be added in the child component, properties or data members
2. From parent we will be doing `property binding`

- child component
```typescript

 @Input() teacher: Teacher;
 @Input('principle') principleName: string;

```

- parent component
```typescript
<app-student *ngFor="let teacher of teachers"
[teacher]="teacher"
[principle]="principle"></app-student>

```


### Child to Parent 
- We will use `@Output` and `EventEmitter` , `emit` and `event binding`
- From child we will use @Output and pass the event Emitter object.
- then we will emit one event, that we need to catch and get the value in parent 

- Child component
```typescript
 @Output() login = new EventEmitter<string>();

   this.login.emit(this.username);


```


- Parent Component : event binding and bind it to an event in the child, login is the event in the child to which we have bind 
```typescript
<app-login (login)="onLogin($event)"></app-login>

```


### Unrelated component via Service
1. Create service store some information there
2. using @Injectable decorator 
3. then use dependency injection in the component where i want to use the information
4. Inject it and subscribe to the service 


- Service 
```Typescript

import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
 providedIn: 'root'
})
export class approvalService {

 private approvalStageMessage = new BehaviorSubject('Basic Approval is required!');
 currentApprovalStageMessage = this.approvalStageMessage.asObservable();

 constructor() {

 }
 updateApprovalMessage(message: string) {
 this.approvalStageMessage.next(message)
 }
}

```

- Component where it is called 
- 
```Typescript

export class BasiccheckComponent implements OnInit {
 message:string="";
 approvalText:string="";
 constructor(private appService:approvalService) { }

 ngOnInit() {
 this.appService.currentApprovalStageMessage.subscribe(msg => this.message = msg);
 
 }

 submit()
 {
 console.log(this.approvalText)
 this.appService.updateApprovalMessage(this.approvalText)
 }

}

```
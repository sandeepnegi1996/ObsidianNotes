# 📑 How to make a rest call using angular

- **🏷️Tags** : #27-04-2022, #review, #reading_list

#### 🔗 Links


## Key Takeaways

## Overview
- HttpClient post method


## Steps
1. `HttpClientModule` import that to AppModule file
2. Import `HTTPClient` in your component, ts file, and add it to the constructor 

### Example
1. add the HttpClient to the constructor
2. use a method http.post , give the endpoint and the body and then subscribe and get the details and store it to data members for later use or just display in the template
3. 

```javascript

import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({ selector: 'app', templateUrl: 'app.component.html' })
export class AppComponent implements OnInit {
    postId;

    constructor(private http: HttpClient) { }

    ngOnInit() {      
        // Simple POST request with a JSON body and response type <any>
        this.http.post<any>('https://reqres.in/api/posts', { title: 'Angular POST Request Example' }).subscribe(data => {
            this.postId = data.id;
        })
    }
}
```


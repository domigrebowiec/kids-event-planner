import { Component } from '@angular/core';

@Component({
  selector: 'my-app',
  template: `<h1>Welcome to {{name}}!</h1>
<my-events></my-events>
  `,
})
export class AppComponent  { name = 'Kids event planner'; }

import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import EventList from './Event.js';



class App extends Component {
  render() {
    return (
      <div className="App">
        <div className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h2>Welcome to React</h2>
        </div>
        <EventList events={events}/>
      </div>
    );
  }
}

const events = [
    {
      "id": "1",
      "name": "Ola's 6 birthday",
      "date": "2018-01-05"
    },
    {
      "id": "2",
      "name": "Wojtek's 4 birthday",
      "date": "2018-01-15"
    }
  ];

export default App;

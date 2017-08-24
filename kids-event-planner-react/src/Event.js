import React, { Component } from 'react';

import './Event.css';

function Event(props) {
  return (
    <tr onClick={props.onClick}>
      <td>{props.event.name}</td>
      <td>{props.event.date}</td>
    </tr>
  );
}

class EventList extends Component {
  constructor() {
    super();
    this.state = {
      eventDetails: null,
    };
  }
  render() {

    return (
      <div>
        <table>
          <thead><tr>
            <th>Name</th>
            <th>Date</th>
          </tr></thead>
          <tbody>
            {this.props.events.map((event) => this.renderEvent(event) )}
          </tbody>
        </table>
        
        <EventDetails event={this.state.eventDetails}/>        
      </div>
    );
  }

  renderEvent(event) {
    return <Event 
              key={event.id} 
              event={event}
              onClick={() => this.handleClick(event)}/>;
  }

  handleClick(event) {
    this.setState({
      eventDetails: event,
    });
  }
}

function EventDetails(props) {
  if (props.event) {
    return (
      <div className="event-details">
        <div className="event-detail"><b>Event details:</b></div>
        <div className="event-detail"><b>Name:</b> {props.event.name}</div>
        <div className="event-detail"><b>Date:</b> {props.event.date}</div>
        <div className="event-detail"><b>Map:</b> Show me on map</div>
      </div>
    );
  } else {
    return (<div className="event-details"><b>No event chosen.</b></div>);
  }
}

export default EventList;
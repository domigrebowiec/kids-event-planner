# kids-event-planner

## Purpose
Application goal is to enable kids event planning. When you plan to go somewhere with your kid then you can publish event to your friends. They can join your event.
You can also schedule some after school activity.

## Architecture
To write the application I use hexagonal architecture (also known as port and adapters).

## Domain
Basic domain consist of: 
- Event, 
- Family and 
- EventParticipants
  -  which consists of families that go on event and families that are interested in event (they want to receive notifications). 

## Basic functionality
- Add new event
- Update, delete event
- Create new family
- Add kid to family
- Update family 
- Family can sign up for event
- Family can mark that is interested in going to event
- Sending notifications (f.e. email notifications)

## Implementation
 - Java, SQLite
 - Angular
 
## Resources
- [Hexagonal Architecture](http://alistair.cockburn.us/Hexagonal+architecture)
- [How to code - tutorial](http://java-design-patterns.com/blog/build-maintainable-systems-with-hexagonal-architecture/)

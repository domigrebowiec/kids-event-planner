package dg.hexagonal.services.database;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import dg.hexagonal.domain.Event;
import dg.hexagonal.domain.ports.required.EventRepository;

@Repository
public class HibernateEventRepo implements EventRepository {

	private SessionFactory sessionFactory;
	
	public Event addEvent(Event event) {
		sessionFactory.getCurrentSession().saveOrUpdate(event);
		return event;
	}

	public Event updateEvent(Event event) {
		sessionFactory.getCurrentSession().saveOrUpdate(event);
		return event;
	}

	public Event getEventById(Long eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Event getEventByName(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public Event deleteEvent(Long eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
}
